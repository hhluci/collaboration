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


}
