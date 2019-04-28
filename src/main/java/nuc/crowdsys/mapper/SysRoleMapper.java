package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysRoleMapper {

    @Select("select * from sys_role ")
    List<SysRole> findAllSysRoles();

    @Insert("INSERT INTO sys_role (available, description, role) VALUES ( #{sysRole.available}, #{sysRole.description}, #{sysRole.role})")
    int addRole(@Param("sysRole") SysRole sysRole);

    @Delete("delete from sys_role where id=#{id}")
    int deleteByid(int id);

    @Select("select * from sys_role where id = #{id}")
    SysRole findByid(int id);

    @Update("update sys_role set role=#{sysRole.role},description=#{sysRole.description},available=#{sysRole.available} where id=#{sysRole.id}")
    int updateSysRole(@Param("sysRole")SysRole sysRole);





}