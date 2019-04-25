package nuc.crowdsys.service;

import nuc.crowdsys.entity.SysUser;

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
    List<SysUser> findAllUsers();
    int addUser(SysUser sysUser);
    int deleteByUid(int uid);
    SysUser findByUid(int uid);

    int updateSysUser(SysUser sysUser);
}
