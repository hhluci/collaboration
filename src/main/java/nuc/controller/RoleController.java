package nuc.controller;

import nuc.entity.SysRole;
import nuc.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.controller
 * @Description:
 * @Date: Created in 14:26 2019-04-17
 */
@Controller
public class RoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/findAllRoles")
    public String findAllRoles(Model model){
        List<SysRole> allRoles=sysRoleService.findAllSysRoles();
        model.addAttribute("allRoles",allRoles);
        System.out.println(model);
        return "rolemanage";
    }
}
