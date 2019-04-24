package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysUser;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper {
    @Select("select * from user_info where username = #{username}")
    SysUser findByUsername(String username);
}