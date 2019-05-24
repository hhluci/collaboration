package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.SysUserRole;
import nuc.crowdsys.mapper.SysRoleMapper;
import nuc.crowdsys.mapper.SysRoleUserMapper;
import nuc.crowdsys.mapper.SysUserMapper;
import nuc.crowdsys.mapper.SysUserRoleMapper;
import nuc.crowdsys.service.SysRoleUserService;
import nuc.crowdsys.service.SysUserRoleService;
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
public class SysRoleUserServiceImpl implements SysRoleUserService {
    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUserRole> findUserRoleByRoleId(int roleId) {
        return sysRoleUserMapper.findUserRoleByRoleId(roleId);
    }

    //@Override
    //public int addUserRole(SysUserRole sysUserRole) {
    //    return sysRoleUserMapper.addUserRole(sysUserRole);
    //}
    //
    //
    //@Override
    //public List<SysUser> getNotSelectedUsers(String roleId) {
    //    SysUser sysUser=new SysUser();
    //    List<SysUser> allUsers = sysUserMapper.findAllUsers(sysUser);
    //    List<SysUserRole> sysUserRoles = findUserRoleByRoleId(Integer.parseInt(roleId));
    //    System.out.println(sysUserRoles);
    //    List<SysUser> notSelectedUsers = new ArrayList<SysUser>();
    //    for (int j = 0; j < allUsers.size(); j++) {
    //        boolean flag = false;
    //        for (int i = 0; i < sysUserRoles.size(); i++) {
    //            if (sysUserRoles.get(i).getUid().equals(allUsers.get(j).getUid())) {
    //                flag = true;
    //            }
    //
    //        }
    //        if (!flag) {
    //            notSelectedUsers.add(allUsers.get(j));
    //        }
    //    }
    //    return notSelectedUsers;
    //}
    //
    //@Override
    //public List<SysUser> getSelectedUsers(String roleId) {
    //
    //    SysUser sysUser=new SysUser();
    //
    //    List<SysUser> allUsers = sysUserMapper.findAllUsers(sysUser);
    //    List<SysUserRole> sysUserRoles = findUserRoleByRoleId(Integer.parseInt(roleId));
    //
    //    List<SysUser> selectedUsers = new ArrayList<SysUser>();
    //    for (int j = 0; j < allUsers.size(); j++) {
    //        for (int i = 0; i < sysUserRoles.size(); i++) {
    //            if (sysUserRoles.get(i).getUid().equals(allUsers.get(j).getUid())) {
    //                selectedUsers.add(allUsers.get(j));
    //            }
    //        }
    //    }
    //    return selectedUsers;
    //}
    //
    //@Override
    //public int deleteAllByRoleId(String roleId) {
    //    return sysRoleUserMapper.deleteAllByRoleId(Integer.parseInt(roleId));
    //}
}