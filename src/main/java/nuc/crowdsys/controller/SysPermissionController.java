package nuc.crowdsys.controller;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.service.SysPermissionService;
import nuc.crowdsys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.controller
 * @Description:
 * @Date: Created in 14:26 2019-04-17
 */
@Controller
@RequestMapping("/sysPermission")
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping("/findAllPermission")
    @RequiresPermissions("syspermission_view")
    public String findAllRoles(Model model) {
        List<SysPermission> allPermissions = sysPermissionService.findAllSysPermissions();
        model.addAttribute("allPermissions", allPermissions);
        return "syspermission/permissionmanage";
    }

    @GetMapping("/addPermission")
    @RequiresPermissions({"syspermission_add"})
    public String addPermission() {
        return "syspermission/addpermission";
    }

    @PostMapping("/toAddPermission")
    @RequiresPermissions("syspermission_add")
    public String toAddUser(SysPermission sysPermission, Model model) {
        System.out.println(sysPermission);

        int msg = sysPermissionService.addPermission(sysPermission);
        if (msg > 0) {
            model.addAttribute("msg", "操作成功！");

        } else {
            model.addAttribute("msg", "操作失败！");
        }
        return "syspermission/addpermission";
    }


    @RequestMapping("/delete")
    @RequiresPermissions("syspermission_delete")
    public String deleteByid(String id, Model model) {
        int msg = sysPermissionService.deleteByid(Integer.parseInt(id));
        if (msg > 0) {
            model.addAttribute("msg", "操作成功！");
        } else {
            model.addAttribute("msg", "操作失败！");
        }
        return "syspermission/permissionstate";
    }


    @RequestMapping("/toUpdate")
    @RequiresPermissions("syspermission_update")
    public String updateById(String id, Model model) {
        SysPermission sysPermission = sysPermissionService.findByid(Integer.parseInt(id));
        model.addAttribute("sysPermission", sysPermission);

        return "syspermission/updatepermission";
    }

    @RequestMapping("/update")
    @RequiresPermissions("syspermission_update")
    public String update(SysPermission sysPermission, Model model) {

        int msg = sysPermissionService.updateSysPermission(sysPermission);
        if (msg > 0) {
            model.addAttribute("msg", "操作成功！");
        } else {
            model.addAttribute("msg", "操作失败！");
        }
        return "syspermission/permissionstate";
    }

    //批量删除
    @RequestMapping("/batchdelete")
    @RequiresPermissions("syspermission_delete")
    public String batchDelete(String tag, Model model) {
        String[] strs = tag.split(",");
        List<String> msgs = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            try {
                int msg = sysPermissionService.deleteByid(Integer.parseInt(strs[i]));
                if (msg > 0) {
                    msgs.add("id为： " + strs[i] + " 删除成功！");
                } else {
                    msgs.add("id为： " + strs[i] + " 删除失败！");
                }
            } catch (Exception e) {
            }
        }
        model.addAttribute("msg", msgs);
        return "syspermission/permissionstate";
    }
}
