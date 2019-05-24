package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysUserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysUserRoleMapper {


    int addUserRole(SysUserRole sysUserRole);

    List<SysUserRole> findUserRoleById(long uid);


    void deleteAllByUid(long uid);

    void deleteUserRoleByRoleId(long id);

}