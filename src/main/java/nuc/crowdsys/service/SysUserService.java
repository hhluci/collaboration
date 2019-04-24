package nuc.crowdsys.service;

import nuc.crowdsys.entity.SysUser;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service
 * @Description:
 * @Date: Created in 18:08 2019-04-16
 */
public interface SysUserService {
    SysUser findByUsername(String username);
}
