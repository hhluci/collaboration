package nuc.crowdsys.controller;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.service.SysPermissionService;
import nuc.crowdsys.service.SysRoleService;
import nuc.crowdsys.utils.ResponseBo;
import nuc.crowdsys.utils.Tree;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/syspermission")
public class SysPermissionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysPermissionService sysPermissionService;


    @RequestMapping("/permission")
    @RequiresPermissions("syspermission_view")
    public String index() {
        return "syspermission/menu";
    }


    @RequestMapping("/list")
    @RequiresPermissions("syspermission_view")
    @ResponseBody
    public List<SysPermission> menuList(SysPermission menu) {
        try {
            return this.sysPermissionService.findAllMenus(menu);
        } catch (Exception e) {
            logger.error("获取菜单集合失败", e);
            return new ArrayList<>();
        }
    }

    @RequestMapping("/tree")
    @ResponseBody
    public ResponseBo getMenuTree() {
        try {
            Tree<SysPermission> tree = this.sysPermissionService.getMenuTree();
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            logger.error("获取菜单树失败", e);
            return ResponseBo.error("获取菜单树失败！");
        }
    }


    @RequestMapping("/checkMenuName")
    @ResponseBody
    public boolean checkMenuName(String name, String type, String oldMenuName) {
        if (StringUtils.isNotBlank(oldMenuName) && StringUtils.equalsIgnoreCase(name, oldMenuName)) {
            return true;
        }
        SysPermission result = this.sysPermissionService.findByNameAndType(name, type);
        return result == null;
    }


    @RequestMapping("/add")
    @RequiresPermissions("syspermission_add")
    @ResponseBody
    public ResponseBo addMenu(SysPermission menu) {
        String name;
        if ("0".equals(menu.getType())) {
            name = "菜单";
        } else {
            name = "按钮";
        }
        if ("on".equalsIgnoreCase(menu.getState())) {
            menu.setState("1");
        } else {
            menu.setState("0");
        }

        try {
            this.sysPermissionService.addMenu(menu);
            return ResponseBo.ok("新增" + name + "成功！");
        } catch (Exception e) {
            logger.error("新增{}失败", name, e);
            return ResponseBo.error("新增" + name + "失败，请联系网站管理员！");
        }
    }


    @RequestMapping("/delete")
    @RequiresPermissions("syspermission_delete")
    @ResponseBody
    public ResponseBo deleteMenus(String ids) {
        try {
            this.sysPermissionService.deleteMeuns(ids);
            return ResponseBo.ok("删除成功！");
        } catch (Exception e) {
            logger.error("获取菜单失败", e);
            return ResponseBo.error("删除失败，请联系网站管理员！");
        }
    }


    @RequestMapping("/getMenu")
    @RequiresPermissions("syspermission_view")
    @ResponseBody
    public ResponseBo getMenu(Long menuId) {
        try {
            SysPermission menu = this.sysPermissionService.findById(menuId);
            return ResponseBo.ok(menu);
        } catch (Exception e) {
            logger.error("获取菜单信息失败", e);
            return ResponseBo.error("获取信息失败，请联系网站管理员！");
        }
    }


    @RequestMapping("/update")
    @RequiresPermissions("syspermission_update")
    @ResponseBody
    public ResponseBo updateMenu(SysPermission menu) {
        String name;
        if ("0".equals(menu.getType())) {
            name = "菜单";
        } else {
            name = "按钮";
        }

        if ("on".equalsIgnoreCase(menu.getState())) {
            menu.setState("1");
        } else {
            menu.setState("0");
        }


        try {
            this.sysPermissionService.updateMenu(menu);
            return ResponseBo.ok("修改" + name + "成功！");
        } catch (Exception e) {
            logger.error("修改{}失败", name, e);
            return ResponseBo.error("修改" + name + "失败，请联系网站管理员！");
        }
    }

}
