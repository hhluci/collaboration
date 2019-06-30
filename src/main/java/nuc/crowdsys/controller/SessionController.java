package nuc.crowdsys.controller;

import nuc.crowdsys.annotation.SystemLog;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.UserOnLine;
import nuc.crowdsys.utils.ResponseBo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

@Controller
@RequestMapping("session")
public class SessionController {

    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SessionDAO sessionDAO;

    @RequestMapping("session")
    @RequiresPermissions("session_view")
    public String online() {
        return "monitor/online";
    }


    @RequestMapping("/kickout")
    @ResponseBody
    @RequiresPermissions("session_kickout")
    @SystemLog(module = "在线用户管理", methods = "强制用户下线")
    public ResponseBo kickOut(String sessionId, HttpServletRequest request, HttpServletResponse response) {
        try {
            String currentSessionId = request.getRequestedSessionId();
            if (StringUtils.equals(sessionId, currentSessionId)) {
                Subject subject = SecurityUtils.getSubject();
                Session session = subject.getSession();
                session.stop();
            } else {
                Session session = sessionDAO.readSession(sessionId);
                session.stop();
            }

            if (StringUtils.equals(sessionId, currentSessionId)) {
                return ResponseBo.ok("refresh");
            } else {
                return ResponseBo.ok();
            }
        } catch (Exception e) {
            log.error("踢出用户失败", e);
            return ResponseBo.error("踢出用户失败，请联系网站管理员！");
        }
    }

    @GetMapping("/active")
    @ResponseBody
    @RequiresPermissions("session_view")
    @SystemLog(module = "在线用户管理", methods = "获取在线用户")
    public Map<String, Object> getAllSession(HttpServletRequest request) {
        try {
            Collection<Session> sessions = sessionDAO.getActiveSessions();
            List<UserOnLine> list = new ArrayList<>();
            for (Session session : sessions) {

                SimplePrincipalCollection simple =
                        (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);

                if (simple != null) {
                    SysUser sysUser = (SysUser) simple.getPrimaryPrincipal();
                    UserOnLine userOnLine = new UserOnLine();
                    userOnLine.setIp(session.getHost());
                    userOnLine.setLastRequested(session.getLastAccessTime());
                    userOnLine.setLoginTime(session.getStartTimestamp());
                    userOnLine.setSessionId((String) session.getId());
                    userOnLine.setUsername(sysUser.getUsername());
                    userOnLine.setLoginType("normal");
                    //System.out.println("登录ip:" + session.getHost());
                    //System.out.println("登录用户" + session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
                    //System.out.println("登录日期日期:" + session.getStartTimestamp());
                    //System.out.println("最后操作日期:" + session.getLastAccessTime());
                    //System.out.println("sessionId:" +session.getId());
                    //System.out.println("过期时间:" +session.getTimeout());
                    list.add(userOnLine);
                } else {
                    continue;
                }

            }

            Map<String, Object> rspData = new HashMap<>();
            rspData.put("rows", list);
            rspData.put("total", list.size());
            return rspData;
        } catch (Exception e) {
            log.error("获取在线用户失败", e);
            return ResponseBo.error("获取在线用户失败，请联系网站管理员！");
        }
    }
}
