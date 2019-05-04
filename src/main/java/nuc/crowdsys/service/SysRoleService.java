package nuc.crowdsys.service;


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
    List<SysRole> findAllSysRoles();

    int addRole(SysRole sysRole);

    int deleteByid(int id);

    SysRole findByid(int id);

    int updateSysRole(SysRole sysRole);

}
