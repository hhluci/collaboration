package nuc.crowdsys.service;



import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRole;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service
 * @Description:
 * @Date: Created in 14:33 2019-04-17
 */
public interface SysPermissionService {
    List<SysPermission> findAllSysPermissions();
    int addPermission(SysPermission sysPermission);
    int deleteByid(int id);
    SysPermission findByid(int id);
    int updateSysPermission(SysPermission sysPermission);

}
