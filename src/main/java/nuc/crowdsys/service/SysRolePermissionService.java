package nuc.crowdsys.service;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRolePermission;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.SysUserRole;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service
 * @Description:
 * @Date: Created in 18:08 2019-04-16
 */
public interface SysRolePermissionService {
    int addRolePermission(SysRolePermission sysRolePermission);


    List<SysRolePermission> findRolePermissionByRoleId(int roleId);

    List<SysPermission> getNotSelectedPermissions(String roleId);

    List<SysPermission> getSelectedPermissions(String roleId);

    int deleteAllByRoleId(String roleId);

}
