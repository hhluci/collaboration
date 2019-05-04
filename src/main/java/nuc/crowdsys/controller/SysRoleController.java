package nuc.crowdsys.controller;

import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.service.SysRoleService;
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
@RequestMapping("/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/findAllRoles")
    public String findAllRoles(Model model) {
        List<SysRole> allRoles = sysRoleService.findAllSysRoles();
        model.addAttribute("allRoles", allRoles);
        System.out.println(model);
        return "sysrole/rolemanage";
    }

    @GetMapping("/addRole")
    public String addUser() {
        return "sysrole/addrole";
    }

    @PostMapping("/toAddRole")
    public String toAddUser(String available, String description, String role, Model model) {

        SysRole sysRole = new SysRole();
        if (Integer.parseInt(available) == 0) {
            sysRole.setAvailable(false);
        } else if (Integer.parseInt(available) == 1) {
            sysRole.setAvailable(true);
        } else {
            model.addAttribute("msg", "添加失败！available取值错误");
            return "sysrole/addrole";
        }
        sysRole.setDescription(description);
        sysRole.setRole(role);
        int msg = sysRoleService.addRole(sysRole);
        if (msg > 0) {
            model.addAttribute("msg", "操作成功！");

        } else {
            model.addAttribute("msg", "操作失败！");
        }
        return "sysrole/addrole";
    }


    @RequestMapping("/delete")
    public String deleteByUid(String id, Model model) {
        int msg = sysRoleService.deleteByid(Integer.parseInt(id));
        if (msg > 0) {
            model.addAttribute("msg", "操作成功！");
        } else {
            model.addAttribute("msg", "操作失败！");
        }
        return "sysrole/rolestate";
    }


    @RequestMapping("/toUpdate")
    public String updateByUid(String id, Model model) {
        SysRole sysRole = sysRoleService.findByid(Integer.parseInt(id));
        model.addAttribute("sysRole", sysRole);

        return "sysrole/updaterole";
    }

    @RequestMapping("/update")
    public String update(String id, String role, String description, String available, Model model) {
        SysRole sysRole = new SysRole();
        sysRole.setRole(role);
        sysRole.setDescription(description);
        if (Integer.parseInt(available) == 0) {
            sysRole.setAvailable(false);
        } else if (Integer.parseInt(available) == 1) {
            sysRole.setAvailable(true);
        }
        sysRole.setId(Integer.parseInt(id));
        int msg = sysRoleService.updateSysRole(sysRole);
        if (msg > 0) {
            model.addAttribute("msg", "操作成功！");
        } else {
            model.addAttribute("msg", "操作失败！");
        }
        return "sysrole/rolestate";
    }


    //批量删除
    @RequestMapping("/batchdelete")
    public String batchDelete(String tag, Model model) {
        String[] strs = tag.split(",");
        List<String> msgs = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            try {
                int msg = sysRoleService.deleteByid(Integer.parseInt(strs[i]));
                if (msg > 0) {
                    msgs.add("id为： " + strs[i] + " 删除成功！");
                } else {
                    msgs.add("id为： " + strs[i] + " 删除失败！");
                }
            } catch (Exception e) {
            }
        }
        model.addAttribute("msg", msgs);
        return "sysrole/rolestate";
    }
}
