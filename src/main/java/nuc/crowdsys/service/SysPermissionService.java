package nuc.crowdsys.service;


import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.utils.Tree;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service
 * @Description:
 * @Date: Created in 14:33 2019-04-17
 */
public interface SysPermissionService {
    List<SysPermission> findAllMenus(SysPermission menu);


    Tree<SysPermission> getMenuTree();

    SysPermission findByNameAndType(String name, String type);

    void addMenu(SysPermission menu);

    void deleteMeuns(String menuIds);

    SysPermission findById(Long menuId);

    void updateMenu(SysPermission menu);


}
