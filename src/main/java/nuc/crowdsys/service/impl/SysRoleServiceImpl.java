package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.mapper.SysRoleMapper;
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
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findAllSysRoles() {
        return sysRoleMapper.findAllSysRoles();
    }

    @Override
    public int addRole(SysRole sysRole) {
        return sysRoleMapper.addRole(sysRole);
    }

    @Override
    public int deleteByid(int id) {
        return sysRoleMapper.deleteByid(id);
    }

    @Override
    public SysRole findByid(int id) {
        return sysRoleMapper.findByid(id);
    }

    @Override
    public int updateSysRole(SysRole sysRole) {
        return sysRoleMapper.updateSysRole(sysRole);
    }
}
