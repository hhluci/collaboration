package nuc.crowdsys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nuc.crowdsys.annotation.SystemLog;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.service.SysUserService;
import nuc.crowdsys.utils.QueryRequest;
import nuc.crowdsys.utils.ResponseBo;
import nuc.crowdsys.utils.SysUserEncry;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static nuc.crowdsys.utils.SysUserEncry.encry;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.controller
 * @Description:
 * @Date: Created in 14:26 2019-04-25
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/checkUserName")
    @ResponseBody
    public boolean checkUserName(String username, String oldusername) {
        if (StringUtils.isNotBlank(oldusername) && StringUtils.equalsIgnoreCase(username, oldusername)) {
            return true;
        }
        SysUser result = sysUserService.findByName(username);
        return result == null;
    }

    @RequestMapping("/regist")
    @ResponseBody
    public ResponseBo regist(SysUser user) {
        try {
            SysUser result = sysUserService.findByName(user.getUsername());

            if (result != null) {
                return ResponseBo.warn("该账号已被使用！");
            }

            user = SysUserEncry.encry(user);

            sysUserService.addUser(user);

            return ResponseBo.ok();
        } catch (Exception e) {
            log.error("注册失败", e);
            return ResponseBo.error("注册失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/user")
    public String index() {
        return "sysuser/user";
    }


    @RequestMapping("/list")
    @RequiresPermissions("sysuser_view")
    @ResponseBody
    @SystemLog(module = "系统用户管理", methods = "查询所有用户")
    public Map<String, Object> userList(QueryRequest request, SysUser sysUser) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserService.findAllUsers(sysUser));
        PageHelper.clearPage();
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());

        return rspData;

    }


    @RequestMapping("/add")
    @RequiresPermissions("sysuser_add")
    @ResponseBody
    @SystemLog(module = "系统用户管理", methods = "添加用户")
    public ResponseBo addUser(SysUser user, Long[] roles) {
        try {
            if ("on".equalsIgnoreCase(user.getState())) {
                user.setState("1");
            } else {
                user.setState("0");
            }
            user = encry(user);
            this.sysUserService.addUser(user, roles);
            return ResponseBo.ok("新增用户成功！");
        } catch (Exception e) {
            log.error("新增用户失败", e);
            return ResponseBo.error("新增用户失败，请联系网站管理员！");
        }
    }


    @RequestMapping("delete")
    @RequiresPermissions("sysuser_delete")
    @ResponseBody
    @SystemLog(module = "系统用户管理", methods = "删除用户")
    public ResponseBo deleteUsers(String ids) {
        try {
            sysUserService.deleteUsers(ids);
            return ResponseBo.ok("删除用户成功！");
        } catch (Exception e) {
            log.error("删除用户失败", e);
            return ResponseBo.error("删除用户失败，请联系网站管理员！");
        }
    }


    @RequestMapping("/getUser")
    @ResponseBody
    public ResponseBo getUser(String userId) {
        try {
            SysUser user = sysUserService.findById(Long.parseLong(userId));
            return ResponseBo.ok(user);
        } catch (Exception e) {
            log.error("获取用户失败", e);
            return ResponseBo.error("获取用户失败，请联系网站管理员！");
        }
    }


    @RequiresPermissions("sysuser_update")
    @RequestMapping("update")
    @ResponseBody
    @SystemLog(module = "系统用户管理", methods = "修改用户")
    public ResponseBo updateUser(SysUser user, Long[] rolesSelect) {
        try {
            if ("on".equalsIgnoreCase(user.getState())) {
                user.setState("1");
            } else {
                user.setState("0");
            }
            sysUserService.updateUser(user, rolesSelect);
            return ResponseBo.ok("修改用户成功！");
        } catch (Exception e) {
            log.error("修改用户失败", e);
            return ResponseBo.error("修改用户失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/checkPassword")
    @ResponseBody
    public boolean checkPassword(String password) {

        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();

        return SysUserEncry.checkUserPassword(user, password);
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    @SystemLog(module = "系统用户管理", methods = "当前用户修改密码")
    public ResponseBo updatePassword(String newPassword) {
        try {
            SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
            user.setPassword(newPassword);
            user = SysUserEncry.encry(user);
            sysUserService.updateUser(user);

            return ResponseBo.ok("更改密码成功，请重新登录！");
        } catch (Exception e) {
            log.error("修改密码失败", e);
            return ResponseBo.error("更改密码失败，请联系网站管理员！");
        }
    }
}
