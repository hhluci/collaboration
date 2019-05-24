package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysRolePermission;

import java.util.List;

public interface SysRolePermissionMapper {


    void addRolePermission(SysRolePermission sysRolePermission);

    List<SysRolePermission> findRolePermissionByRoleId(long roleId);

    void deleteRolePermissionByRoleId(long id);

    void deleteRolePermisssionsByPId(long id);



}