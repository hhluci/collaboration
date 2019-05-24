package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.UserWithRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysUserMapper {
    SysUser findByUsername(String username);

    List<SysUser> findAllByUsername(String username);


    List<SysUser> findAllUsers(SysUser sysUser);


    int addUser(SysUser sysUser);

    void deleteByUid(long uid);

    void updateSysUser(SysUser sysUser);


    void updateSysUserNokey(SysUser sysUser);


    List<UserWithRole> findUserWithRole(Long userId);

}
