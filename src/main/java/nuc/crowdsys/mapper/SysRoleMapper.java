package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMapper {

    @Select("select * from sys_role ")
    List<SysRole> findAllSysRoles();

}