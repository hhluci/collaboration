package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.RoleWithMenu;
import nuc.crowdsys.entity.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysRoleMapper {

    List<SysRole> findAllSysRoles();

    List<SysRole> findAllRoleByRole(SysRole sysRole);

    void addRole(SysRole sysRole);


    void deleteById(long id);

    List<RoleWithMenu> findById(Long roleId);


    void updateRole(SysRole sysRole);
}