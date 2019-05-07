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
    public int[] getSelectedPermissionsId(String roleId) {
        List<SysPermission> selectedPermissions = getSelectedPermissions(roleId);
        int[] selectedPermissionsId = new int[selectedPermissions.size()];
        for (int i = 0; i < selectedPermissions.size(); i++) {
            selectedPermissionsId[i] = selectedPermissions.get(i).getId();
        }
        return selectedPermissionsId;
    }

    @Override
    public int deleteAllByRoleId(String roleId) {
        return sysRolePermissionMapper.deleteAllByRoleId(Integer.parseInt(roleId));
    }

    @Override
    public List<SysPermission> getPermissionsTree() {
        List<SysPermission> allPermissions = sysPermissionMapper.findAllSysPermissions();
        List<SysPermission> rootPermissions = sysPermissionMapper.getRootPermissions();
        for (SysPermission sysPermission : rootPermissions) {
            sysPermission.setChilds(getChild(sysPermission.getId(), allPermissions));
        }

        return rootPermissions;
    }

    //递归为child赋值
    private List<SysPermission> getChild(Integer id, List<SysPermission> allPermissions) {
        // 子菜单
        List<SysPermission> childList = new ArrayList<>();
        for (SysPermission sysPermission : allPermissions) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (sysPermission.getParentId() != null) {
                if (sysPermission.getParentId().equals(id)) {
                    childList.add(sysPermission);
                }
            }
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }

        // 把子菜单的子菜单再循环一遍
        for (SysPermission sysPermission : childList) {
            if (sysPermission.getParentId() != null) {
                if (sysPermission.getParentId().equals(id)) {
                    sysPermission.setChilds(getChild(sysPermission.getId(), allPermissions));

                }
            }
        }

        return childList;
    }
}