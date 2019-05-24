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



}
