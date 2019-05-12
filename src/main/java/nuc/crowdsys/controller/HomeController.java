package nuc.crowdsys.controller;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.service.HomeService;
import nuc.crowdsys.utils.ResponseBo;
import nuc.crowdsys.utils.Tree;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HomeService homeService;


    @RequestMapping("menu/getUserMenu")
    @ResponseBody
    public ResponseBo getUserMenu(Integer userId) {
        try {
            Tree<SysPermission> tree = homeService.getUserMenu(userId);
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            logger.error("获取用户菜单失败", e);
            return ResponseBo.error("获取用户菜单失败！");
        }
    }

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request) throws Exception {

        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        return map;
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        return "403";
    }
}