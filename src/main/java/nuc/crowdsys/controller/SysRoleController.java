package nuc.crowdsys.controller;

import nuc.crowdsys.annotation.SystemLog;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.service.SysRoleService;
import nuc.crowdsys.utils.QueryRequest;
import nuc.crowdsys.utils.ResponseBo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.controller
 * @Description:
 * @Date: Created in 14:26 2019-04-17
 */
@Controller
@RequestMapping("/sysrole")
public class SysRoleController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/list")
    @RequiresPermissions("sysrole_view")
    @ResponseBody
    @SystemLog(module = "系统角色管理", methods = "查询所有角色")
    public Map<String, Object> roleList(QueryRequest request) {
        return super.selectByPageNumSize(request, () -> this.sysRoleService.findAllRole());
    }


    @RequestMapping("/role")
    @RequiresPermissions("sysrole_view")

    public String index() {
        return "sysrole/role";
    }

    @RequestMapping("/listbyrole")
    @RequiresPermissions("sysrole_view")
    @ResponseBody
    public Map<String, Object> roleList(QueryRequest request, SysRole role) {

        return super.selectByPageNumSize(request, () -> this.sysRoleService.findAllRoleByRole(role));


    }


    @RequestMapping("/add")
    @RequiresPermissions("sysrole_add")
    @ResponseBody
    @SystemLog(module = "系统角色管理", methods = "添加角色")
    public ResponseBo addRole(SysRole role, Long[] menuId) {
        try {
            if ("on".equalsIgnoreCase(role.getState())) {
                role.setState("1");
            } else {
                role.setState("0");
            }

            this.sysRoleService.addRole(role, menuId);
            return ResponseBo.ok("新增角色成功！");
        } catch (Exception e) {
            log.error("新增角色失败", e);
            return ResponseBo.error("新增角色失败，请联系网站管理员！");
        }
    }


    @RequestMapping("/delete")
    @RequiresPermissions("sysrole_delete")
    @ResponseBody
    @SystemLog(module = "系统角色管理", methods = "删除角色")
    public ResponseBo deleteRoles(String ids) {
        try {
            this.sysRoleService.deleteRoles(ids);
            return ResponseBo.ok("删除角色成功！");
        } catch (Exception e) {
            log.error("删除角色失败", e);
            return ResponseBo.error("删除角色失败，请联系网站管理员！");
        }
    }


    @RequestMapping("/getRole")
    @RequiresPermissions("sysrole_view")
    @ResponseBody
    public ResponseBo getRole(Long roleId) {
        try {
            SysRole role = sysRoleService.findRoleWithMenus(roleId);
            return ResponseBo.ok(role);
        } catch (Exception e) {
            log.error("获取角色信息失败", e);
            return ResponseBo.error("获取角色信息失败，请联系网站管理员！");
        }
    }


    @RequestMapping("/update")
    @RequiresPermissions({"sysrole_update", "sysrole_setpermissions"})
    @ResponseBody
    @SystemLog(module = "系统角色管理", methods = "修改角色")
    public ResponseBo updateRole(SysRole role, Long[] menuId) {
        try {
            if ("on".equalsIgnoreCase(role.getState())) {
                role.setState("1");
            } else {
                role.setState("0");
            }
            sysRoleService.updateRole(role, menuId);
            return ResponseBo.ok("修改角色成功！");
        } catch (Exception e) {
            log.error("修改角色失败", e);
            return ResponseBo.error("修改角色失败，请联系网站管理员！");
        }
    }

}
