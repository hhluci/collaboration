package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysUserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysUserRoleMapper {


    @Insert("INSERT INTO sys_user_role (uid,role_id) VALUES ( #{sysUserRole.uid}, #{sysUserRole.roleId})")
    int addUserRole(@Param("sysUserRole") SysUserRole sysUserRole);

    @Select("select * from sys_user_role where uid= #{uid}")
    List<SysUserRole> findUserRoleById(int uid);


    @Delete("delete from sys_user_role where uid=#{uid}")
    int deleteAllByUid(int uid);
}