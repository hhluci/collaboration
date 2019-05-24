package nuc.crowdsys.service;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.utils.Tree;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.crowdsys.service
 * @Description:
 * @Date: Created in 17:13 2019-05-12
 */
public interface MenuService {
    Tree<SysPermission> getUserMenu(Integer uId);

    List<SysPermission> findUserMenus(Integer uId);


    Tree<SysPermission> getMenuButtonTree();

}
