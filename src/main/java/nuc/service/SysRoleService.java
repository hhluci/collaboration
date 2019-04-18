package nuc.service;

import nuc.entity.SysRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service
 * @Description:
 * @Date: Created in 14:33 2019-04-17
 */
public interface SysRoleService {
    public List<SysRole> findAllSysRoles();
}
