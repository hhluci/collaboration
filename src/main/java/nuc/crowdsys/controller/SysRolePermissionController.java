package nuc.crowdsys.controller;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysRolePermission;
import nuc.crowdsys.entity.SysUserRole;
import nuc.crowdsys.service.SysRolePermissionService;
import nuc.crowdsys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/SysRolePermission")
public class SysRolePermissionController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @RequestMapping("/TosetPermission")
    @RequiresPermissions("sysrole_setpermissions")
    public String toSetUser(String roleId, Model model) {
        SysRole sysRole = sysRoleService.findByid(Integer.parseInt(roleId));
        List<SysPermission> permissionsTree = sysRolePermissionService.getPermissionsTree();
        int[] selectedPermissionsId = sysRolePermissionService.getSelectedPermissionsId(roleId);

        model.addAttribute("sysRole", sysRole);
        model.addAttribute("permissionsTree", permissionsTree);
        model.addAttribute("selectedPermissionsId", selectedPermissionsId);

        return "sys_role_permission/setpermission1";
    }

    @RequestMapping("/setPermission")
    @RequiresPermissions("sysrole_setpermissions")
    public String setUser(@RequestParam("roleId") String roleId, @RequestParam("permissions") String[] permissions, Model model) {
        List<String> msgs = new ArrayList<>();
        int msg1 = sysRolePermissionService.deleteAllByRoleId(roleId);

        for (int i = 0; i < permissions.length; i++) {
            SysRolePermission sysRolePermission = new SysRolePermission();

            sysRolePermission.setRoleId(Integer.parseInt(roleId));
            sysRolePermission.setPermissionId(Integer.parseInt(permissions[i]));
            int msg = sysRolePermissionService.addRolePermission(sysRolePermission);

            if (msg > 0) {
                msgs.add("成功授予角色id为：  " + permissions[i] + " 的权限！");
            } else {
                msgs.add("授予角色id为： " + permissions[i] + " 的权限失败");
            }
        }
        model.addAttribute("msg", msgs);

        return "sysrole/rolestate";
    }
}
