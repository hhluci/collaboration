package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.mapper.SysUserMapper;
import nuc.crowdsys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service.impl
 * @Description:
 * @Date: Created in 18:09 2019-04-16
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private final SysUserMapper userMapper;

    @Autowired
    public SysUserServiceImpl(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public SysUser findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public List<SysUser> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public int addUser(SysUser sysUser) {
        return userMapper.addUser(sysUser);
    }

    @Override
    public int deleteByUid(int uid) {
        return userMapper.deleteByUid(uid);
    }

    @Override
    public SysUser findByUid(int uid) {
        return userMapper.findByUid(uid);
    }

    @Override
    public int updateSysUser(SysUser sysUser) {
        return userMapper.updateSysUser(sysUser);
    }
}
