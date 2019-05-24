package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.SysUserRole;
import nuc.crowdsys.entity.UserWithRole;
import nuc.crowdsys.mapper.SysUserMapper;
import nuc.crowdsys.mapper.SysUserRoleMapper;
import nuc.crowdsys.service.SysUserRoleService;
import nuc.crowdsys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static nuc.crowdsys.utils.SysUserEncry.encry;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service.impl
 * @Description:
 * @Date: Created in 18:09 2019-04-16
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public void addUser(SysUser user, Long[] roles) {
        userMapper.addUser(user);

        setUserRoles(user, roles);
    }

    @Override
    public void addUser(SysUser user) {
        userMapper.addUser(user);

    }

    @Override
    public void setUserRoles(SysUser user, Long[] roles) {
        for (Long i : roles) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUid(user.getUid());
            sysUserRole.setRoleId(i);
            sysUserRoleMapper.addUserRole(sysUserRole);
        }
    }


    @Override
    public SysUser findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public List<SysUser> findAllUsers(SysUser sysUser) {
        return userMapper.findAllUsers(sysUser);
    }


    @Override
    public void deleteUsers(String userIds) {
        List<String> list = Arrays.asList(userIds.split(","));
        batchDelete(list);

        sysUserRoleService.deleteUserRolesByUserId(userIds);
    }

    public void batchDelete(List<String> list) {
        for (String id : list) {
            userMapper.deleteByUid(Long.parseLong(id));
        }
    }


    @Override
    public SysUser findByName(String userName) {
        List<SysUser> list = userMapper.findAllByUsername(userName.toLowerCase());
        return list.isEmpty() ? null : list.get(0);
    }


    @Override
    public UserWithRole findById(Long userId) {
        List<UserWithRole> list = this.userMapper.findUserWithRole(userId);

        List<Long> roleList = new ArrayList<>();
        for (UserWithRole uwr : list) {
            roleList.add(uwr.getRoleId());
        }
        if (list.isEmpty()) {
            return null;
        }
        UserWithRole userWithRole = list.get(0);
        userWithRole.setRoleIds(roleList);
        return userWithRole;
    }


    @Override
    public void updateUser(SysUser user, Long[] roles) {
        //更新用户信息
        System.out.println(user);
        if (user.getPassword() == null || user.getPassword().equals("")) {
            System.out.println("设置密码为默认密码");
            user.setPassword("123456");
        }
        System.out.println(user.getPassword());
        System.out.println("不修改仍为原密码！");
        System.out.println(user.getPassword().equals("不修改仍为原密码！"));
        if (user.getPassword().equals("不修改仍为原密码！")) {
            System.out.println("不修改密码");
            userMapper.updateSysUserNokey(user);
        } else {
            System.out.println("修改密码");
            user = encry(user);
            userMapper.updateSysUser(user);

        }

        //删除用户角色绑定
        sysUserRoleMapper.deleteAllByUid(user.getUid());

        //绑定角色
        for (long roleid : roles) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUid(user.getUid());
            sysUserRole.setRoleId(roleid);
            sysUserRoleMapper.addUserRole(sysUserRole);
        }

    }

    @Override
    @Transactional
    public void updateUser(SysUser user) {
        //更新用户信息
        userMapper.updateSysUser(user);


    }
}
