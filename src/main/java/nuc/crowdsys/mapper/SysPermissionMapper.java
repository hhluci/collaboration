package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysPermissionMapper {

    @Select("select * from sys_permission ")
    List<SysPermission> findAllSysPermissions();

    @Insert("INSERT INTO sys_permission (available, name, parent_id, parent_ids, permission, resource_type, url) VALUES ( #{sysPermission.available}, #{sysPermission.name}, #{sysPermission.parentId},#{sysPermission.parentIds}, #{sysPermission.permission}, #{sysPermission.resourceType}, #{sysPermission.url});")
    int addPermission(@Param("sysPermission") SysPermission sysPermission);

    @Delete("delete from sys_permission where id=#{id}")
    int deleteByid(int id);

    @Select("select * from sys_permission where id = #{id}")
    SysPermission findByid(int id);

    @Update("update sys_permission set available=#{sysPermission.available},name=#{sysPermission.name},parent_id=#{sysPermission.parentId},parent_ids=#{sysPermission.parentIds},permission=#{sysPermission.permission},resource_type=#{sysPermission.resourceType},url=#{sysPermission.url} where id=#{sysPermission.id}")
    int updateSysPermission(@Param("sysPermission") SysPermission sysPermission);


}