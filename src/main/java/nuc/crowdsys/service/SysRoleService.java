package nuc.crowdsys.service;


import nuc.crowdsys.entity.RoleWithMenu;
import nuc.crowdsys.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service
 * @Description:
 * @Date: Created in 14:33 2019-04-17
 */
public interface SysRoleService {
    List<SysRole> findAllRole();

    List<SysRole> findAllRoleByRole(SysRole sysRole);

    void addRole(SysRole role, Long[] menuIds);

    void deleteRoles(String roleIds);

    RoleWithMenu findRoleWithMenus(Long roleId);

    void updateRole(SysRole role, Long[] menuIds);




}
