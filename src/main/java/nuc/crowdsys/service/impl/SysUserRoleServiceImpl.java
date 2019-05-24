package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.SysUserRole;
import nuc.crowdsys.mapper.SysRoleMapper;
import nuc.crowdsys.mapper.SysUserMapper;
import nuc.crowdsys.mapper.SysUserRoleMapper;
import nuc.crowdsys.service.SysUserRoleService;
import nuc.crowdsys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service.impl
 * @Description:
 * @Date: Created in 18:09 2019-04-16
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Override
    public List<SysUserRole> findUserRoleById(long uid) {
        return sysUserRoleMapper.findUserRoleById(uid);
    }

    @Override
    public List<SysRole> getSelectedRoles(long uid) {
        List<SysRole> allRoles = sysRoleMapper.findAllSysRoles();
        List<SysUserRole> sysUserRoles = findUserRoleById(uid);
        List<SysRole> selectedRoles = new ArrayList<SysRole>();
        for (int j = 0; j < allRoles.size(); j++) {
            for (int i = 0; i < sysUserRoles.size(); i++) {
                if (sysUserRoles.get(i).getRoleId().equals(allRoles.get(j).getId())) {
                    selectedRoles.add(allRoles.get(j));
                }
            }
        }
        return selectedRoles;
    }


    @Override
    @Transactional
    public void deleteUserRolesByUserId(String userIds) {
        List<String> list = Arrays.asList(userIds.split(","));
        for (String id : list) {
            sysUserRoleMapper.deleteAllByUid(Long.parseLong(id));
        }
    }


    //@Override
    //public int addUserRole(SysUserRole sysUserRole) {
    //    return sysUserRoleMapper.addUserRole(sysUserRole);
    //}
    //
    //
    //@Override
    //public List<SysRole> getNotSelectedRoles(String uid) {
    //    List<SysRole> allRoles = sysRoleMapper.findAllSysRoles();
    //    List<SysUserRole> sysUserRoles = findUserRoleById(Integer.parseInt(uid));
    //
    //    List<SysRole> notSelectedRoles = new ArrayList<SysRole>();
    //    for (int j = 0; j < allRoles.size(); j++) {
    //        boolean flag = false;
    //        for (int i = 0; i < sysUserRoles.size(); i++) {
    //            if (sysUserRoles.get(i).getRoleId().equals(allRoles.get(j).getId())) {
    //                flag = true;
    //            }
    //        }
    //        if (!flag) {
    //            notSelectedRoles.add(allRoles.get(j));
    //        }
    //    }
    //    return notSelectedRoles;
    //}
    //
    //
    //
    //@Override
    //public int deleteAllByUid(String uid) {
    //    return sysUserRoleMapper.deleteAllByUid(Integer.parseInt(uid));
    //}
}