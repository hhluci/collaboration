package nuc.crowdsys.realm;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.service.SysRolePermissionService;
import nuc.crowdsys.service.SysUserRoleService;
import nuc.crowdsys.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class ShiroAuthRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principals.getPrimaryPrincipal();

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
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser,
                sysUser.getPassword(),
                ByteSource.Util.bytes(sysUser.getCredentialsSalt()),
                getName()
        );
        return authenticationInfo;
    }
}
