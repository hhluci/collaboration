package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.mapper.SysPermissionMapper;
import nuc.crowdsys.mapper.SysRoleMapper;
import nuc.crowdsys.service.SysPermissionService;
import nuc.crowdsys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service.impl
 * @Description:
 * @Date: Created in 14:34 2019-04-17
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> findAllSysPermissions() {
        return sysPermissionMapper.findAllSysPermissions();
    }

    @Override
    public int addPermission(SysPermission sysPermission) {
        return sysPermissionMapper.addPermission(sysPermission);
    }

    @Override
    public int deleteByid(int id) {
        return sysPermissionMapper.deleteByid(id);
    }

    @Override
    public SysPermission findByid(int id) {
        return sysPermissionMapper.findByid(id);
    }

    @Override
    public int updateSysPermission(SysPermission sysPermission) {
        return sysPermissionMapper.updateSysPermission(sysPermission);
    }

}
