package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRolePermission;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.SysUserRole;
import nuc.crowdsys.mapper.SysPermissionMapper;
import nuc.crowdsys.mapper.SysRolePermissionMapper;
import nuc.crowdsys.mapper.SysRoleUserMapper;
import nuc.crowdsys.mapper.SysUserMapper;
import nuc.crowdsys.service.SysRolePermissionService;
import nuc.crowdsys.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service.impl
 * @Description:
 * @Date: Created in 18:09 2019-04-16
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;


    @Override
    public int addRolePermission(SysRolePermission sysRolePermission) {
        return sysRolePermissionMapper.addRolePermission(sysRolePermission);
    }

    @Override
    public List<SysRolePermission> findRolePermissionByRoleId(int roleId) {
        return sysRolePermissionMapper.findRolePermissionByRoleId(roleId);
    }

    @Override
    public List<SysPermission> getNotSelectedPermissions(String roleId) {
        List<SysPermission> allPermissions = sysPermissionMapper.findAllSysPermissions();

        List<SysRolePermission> sysRolePermissions = findRolePermissionByRoleId(Integer.parseInt(roleId));
        System.out.println(sysRolePermissions);
        List<SysPermission> notSelectedPermissions = new ArrayList<SysPermission>();

        for (int j = 0; j < allPermissions.size(); j++) {
            boolean flag = false;
            for (int i = 0; i < sysRolePermissions.size(); i++) {
                if (sysRolePermissions.get(i).getPermissionId().equals(allPermissions.get(j).getId())) {
                    flag = true;
                }

            }
            if (!flag) {
                notSelectedPermissions.add(allPermissions.get(j));
            }
        }
        return notSelectedPermissions;
    }

    @Override
    public List<SysPermission> getSelectedPermissions(String roleId) {
        List<SysPermission> allPermissions = sysPermissionMapper.findAllSysPermissions();

        List<SysRolePermission> sysRolePermissions = findRolePermissionByRoleId(Integer.parseInt(roleId));
        List<SysPermission> selectedPermissions = new ArrayList<SysPermission>();

        for (int j = 0; j < allPermissions.size(); j++) {
            for (int i = 0; i < sysRolePermissions.size(); i++) {
                if (sysRolePermissions.get(i).getPermissionId().equals(allPermissions.get(j).getId())) {
                    selectedPermissions.add(allPermissions.get(j));
                }
            }
        }
        return selectedPermissions;
    }

    @Override
    public int deleteAllByRoleId(String roleId) {
        return sysRolePermissionMapper.deleteAllByRoleId(Integer.parseInt(roleId));
    }
}