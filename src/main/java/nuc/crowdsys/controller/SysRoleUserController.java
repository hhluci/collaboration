package nuc.crowdsys.controller;

import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.SysUserRole;
import nuc.crowdsys.service.SysRoleService;
import nuc.crowdsys.service.SysRoleUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.crowdsys.controller
 * @Description:
 * @Date: Created in 17:48 2019-04-29
 */
@Controller
@RequestMapping("/SysRoleUser")
public class SysRoleUserController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleUserService sysRoleUserService;

    @RequestMapping("/TosetUser")
    @RequiresPermissions("sysrole_setusers")
    public String toSetUser(String roleId, Model model) {
        SysRole sysRole = sysRoleService.findByid(Integer.parseInt(roleId));
        List<SysUser> notSelectedUsers = sysRoleUserService.getNotSelectedUsers(roleId);
        List<SysUser> selectedUsers = sysRoleUserService.getSelectedUsers(roleId);

        model.addAttribute("sysRole", sysRole);
        model.addAttribute("notSelectedUsers", notSelectedUsers);
        model.addAttribute("selectedUsers", selectedUsers);

        return "sys_role_user/setuser";
    }

    @RequestMapping("/setUser")
    @RequiresPermissions("sysrole_setusers")
    public String setUser(String roleId, String[] allId, Model model) {
        List<String> msgs = new ArrayList<>();
        int msg1 = sysRoleUserService.deleteAllByRoleId(roleId);

        for (int i = 0; i < allId.length; i++) {
            SysUserRole sysUserRole = new SysUserRole();

            sysUserRole.setRoleId(Integer.parseInt(roleId));
            sysUserRole.setUid(Integer.parseInt(allId[i]));
            int msg = sysRoleUserService.addUserRole(sysUserRole);

            if (msg > 0) {
                msgs.add("成功绑定id为：  " + allId[i] + " 的用户！");
            } else {
                msgs.add("绑定id为： " + allId[i] + " 的用户失败");
            }
        }
        model.addAttribute("msg", msgs);

        return "sysrole/rolestate";
    }
}
