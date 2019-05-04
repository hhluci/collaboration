package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysUserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleUserMapper {


    @Insert("INSERT INTO sys_user_role (uid,role_id) VALUES ( #{sysUserRole.uid}, #{sysUserRole.roleId})")
    int addUserRole(@Param("sysUserRole") SysUserRole sysUserRole);

    @Select("select * from sys_user_role where role_id= #{roleId}")
    List<SysUserRole> findUserRoleByRoleId(int roleId);

    @Delete("delete from sys_user_role where role_id=#{roleId}")
    int deleteAllByRoleId(int roleId);
}