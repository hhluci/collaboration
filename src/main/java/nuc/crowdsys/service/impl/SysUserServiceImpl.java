package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.mapper.SysUserMapper;
import nuc.crowdsys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
