package nuc.crowdsys.service;

import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.entity.UserWithRole;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service
 * @Description:
 * @Date: Created in 18:08 2019-04-16
 */
public interface SysUserService {
    SysUser findByUsername(String username);

    List<SysUser> findAllUsers(SysUser sysUser);

    void addUser(SysUser user, Long[] roles);

    void addUser(SysUser user);

    void setUserRoles(SysUser user, Long[] roles);

    void deleteUsers(String userIds);

    SysUser findByName(String userName);

    UserWithRole findById(Long userId);


    void updateUser(SysUser user, Long[] roles);

    void updateUser(SysUser user);

}
