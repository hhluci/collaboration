package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRolePermission;
import nuc.crowdsys.entity.SysUserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRolePermissionMapper {


    @Insert("INSERT INTO sys_role_permission (permission_id,role_id) VALUES ( #{sysRolePermission.permissionId}, #{sysRolePermission.roleId})")
    int addRolePermission(@Param("sysRolePermission") SysRolePermission sysRolePermission);

    @Select("select * from sys_role_permission where role_id= #{roleId}")
    List<SysRolePermission> findRolePermissionByRoleId(int roleId);

    @Delete("delete from sys_role_permission where role_id=#{roleId}")
    int deleteAllByRoleId(int roleId);
}