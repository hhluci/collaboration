package nuc.crowdsys.service.impl;


import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRolePermission;
import nuc.crowdsys.mapper.SysPermissionMapper;
import nuc.crowdsys.mapper.SysRolePermissionMapper;
import nuc.crowdsys.service.SysRolePermissionService;
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
    public List<SysRolePermission> findRolePermissionByRoleId(long roleId) {
        return sysRolePermissionMapper.findRolePermissionByRoleId(roleId);
    }


    @Override
    public List<SysPermission> getSelectedPermissions(long roleId) {
        List<SysPermission> allPermissions = sysPermissionMapper.findAllSysPermissions();

        List<SysRolePermission> sysRolePermissions = findRolePermissionByRoleId(roleId);
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

}