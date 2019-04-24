package nuc.crowdsys.service;



import nuc.crowdsys.entity.SysRole;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service
 * @Description:
 * @Date: Created in 14:33 2019-04-17
 */
public interface SysRoleService {
    public List<SysRole> findAllSysRoles();
}
