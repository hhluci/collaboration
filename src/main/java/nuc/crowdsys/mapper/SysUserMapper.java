package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface SysUserMapper {
    @Select("select * from sys_user where username = #{username}")
    SysUser findByUsername(String username);

    @Select("select * from sys_user where uid = #{uid}")
    SysUser findByUid(int uid);

    @Select("select * from sys_user")
    List<SysUser> findAllUsers();


    @Insert("INSERT INTO sys_user (name, password, salt, username,state) VALUES ( #{sysUser.name}, #{sysUser.password}, #{sysUser.salt}, #{sysUser.username},#{sysUser.state} )")
    int addUser(@Param("sysUser")SysUser sysUser);

    @Delete("delete from sys_user where uid=#{uid}")
    int deleteByUid(int uid);

    @Update("update sys_user set username=#{sysUser.username},name=#{sysUser.name},password=#{sysUser.password},salt=#{sysUser.salt},state=#{sysUser.state} where uid=#{sysUser.uid}")
    int updateSysUser(@Param("sysUser")SysUser sysUser);
}
