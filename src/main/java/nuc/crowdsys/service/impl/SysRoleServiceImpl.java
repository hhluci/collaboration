package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.RoleWithMenu;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysRolePermission;
import nuc.crowdsys.entity.SysUserRole;
import nuc.crowdsys.mapper.SysRoleMapper;
import nuc.crowdsys.mapper.SysRolePermissionMapper;
import nuc.crowdsys.mapper.SysUserRoleMapper;
import nuc.crowdsys.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
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
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    @Override
    public List<SysRole> findAllRole() {
        try {

            return sysRoleMapper.findAllSysRoles();
        } catch (Exception e) {
            log.error("获取角色信息失败", e);
            return new ArrayList<>();
        }
    }

    @Override
    public List<SysRole> findAllRoleByRole(SysRole role) {
        return sysRoleMapper.findAllRoleByRole(role);
    }


    @Override
    public void addRole(SysRole role, Long[] menuIds) {
        //添加角色，并返回id赋值到role中
        sysRoleMapper.addRole(role);


        //循环绑定权限
        for (long i : menuIds) {
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setRoleId(role.getId());
            sysRolePermission.setPermissionId(i);

            sysRolePermissionMapper.addRolePermission(sysRolePermission);
        }
    }


    @Override
    public void deleteRoles(String roleIds) {
        List<String> list = Arrays.asList(roleIds.split(","));

        //删除这些角色
        for (String id : list) {
            sysRoleMapper.deleteById(Long.parseLong(id));
        }

        //删除这些角色与用户的绑定
        for (String id : list) {
            sysUserRoleMapper.deleteUserRoleByRoleId(Long.parseLong(id));
        }
        //删除这些角色与权限的绑定
        for (String id : list) {
            sysRolePermissionMapper.deleteRolePermissionByRoleId(Long.parseLong(id));
        }
    }

    @Override
    public RoleWithMenu findRoleWithMenus(Long roleId) {
        List<RoleWithMenu> list = sysRoleMapper.findById(roleId);

        List<Long> menuList = new ArrayList<>();
        for (RoleWithMenu rwm : list) {
            menuList.add(rwm.getPermissionId());
        }
        if (list.isEmpty()) {
            return null;
        }
        RoleWithMenu roleWithMenu = list.get(0);
        roleWithMenu.setPermissionIds(menuList);
        return roleWithMenu;
    }


    @Override
    public void updateRole(SysRole role, Long[] menuIds) {
        //更新用户信息
        sysRoleMapper.updateRole(role);

        //删除角色权限绑定
        sysRolePermissionMapper.deleteRolePermissionByRoleId(role.getId());

        //绑定角色
        for (long permissionId : menuIds) {
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setPermissionId(permissionId);
            sysRolePermission.setRoleId(role.getId());
            sysRolePermissionMapper.addRolePermission(sysRolePermission);


        }

    }

}
