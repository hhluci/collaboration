package nuc.crowdsys.realm;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.service.SysRolePermissionService;
import nuc.crowdsys.service.SysUserRoleService;
import nuc.crowdsys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;


public class ShiroAuthRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRolePermissionService sysRolePermissionService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser user = (SysUser) principals.getPrimaryPrincipal();


        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        for (SysRole role : sysUserRoleService.getSelectedRoles(user.getUid())) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission p : sysRolePermissionService.getSelectedPermissions(role.getId())) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        String username = (String) token.getPrincipal();
        SysUser sysUser = sysUserService.findByUsername(username);
        if (sysUser == null) {
            return null;
        }

        //处理session
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager) securityManager.getSessionManager();
        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表

        if (sessions != null) {
            for (Session session : sessions) {
                //清除该用户以前登录时保存的session
                SimplePrincipalCollection simple =
                        (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);

                if (simple != null) {
                    SysUser user = (SysUser) simple.getPrimaryPrincipal();
                    if (sysUser.getUsername().equals(user.getUsername())) {
                        sessionManager.getSessionDAO().delete(session);
                    }
                } else {
                    continue;
                }
            }
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser,
                sysUser.getPassword(),
                ByteSource.Util.bytes(sysUser.getCredentialsSalt()),
                getName()
        );

        return authenticationInfo;
    }
}