package nuc.crowdsys.service;

import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.SysUserRole;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service
 * @Description:
 * @Date: Created in 18:08 2019-04-16
 */
public interface SysRoleUserService {
    List<SysUserRole> findUserRoleByRoleId(int roleId);


}
