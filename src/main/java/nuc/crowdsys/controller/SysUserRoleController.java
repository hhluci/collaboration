package nuc.crowdsys.controller;

import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.SysUserRole;
import nuc.crowdsys.service.SysUserRoleService;
import nuc.crowdsys.service.SysUserService;
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
@RequestMapping("/SysUserRole")
public class SysUserRoleController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @RequestMapping("/TosetRole")
    @RequiresPermissions("sysuser_setroles")
    public String toSetRole(String uid, Model model) {
        SysUser sysUser = sysUserService.findByUid(Integer.parseInt(uid));
        List<SysRole> notSelectedRoles = sysUserRoleService.getNotSelectedRoles(uid);
        List<SysRole> selectedRoles = sysUserRoleService.getSelectedRoles(uid);

        model.addAttribute("sysUser", sysUser);
        model.addAttribute("notSelectedRoles", notSelectedRoles);
        model.addAttribute("selectedRoles", selectedRoles);

        return "sys_user_role/setrole";
    }

    @RequestMapping("/setRole")
    @RequiresPermissions("sysuser_setroles")
    public String setRole(String userId, String[] allId, Model model) {
        List<String> msgs = new ArrayList<>();
        int msg1 = sysUserRoleService.deleteAllByUid(userId);
        for (int i = 0; i < allId.length; i++) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUid(Integer.parseInt(userId));
            sysUserRole.setRoleId(Integer.parseInt(allId[i]));
            int msg = sysUserRoleService.addUserRole(sysUserRole);

            if (msg > 0) {
                msgs.add("成功绑定id为：  " + allId[i] + " 的角色");
            } else {
                msgs.add("绑定id为： " + allId[i] + " 的角色失败");
            }
        }
        model.addAttribute("msg", msgs);

        return "sysuser/userstate";
    }
}
