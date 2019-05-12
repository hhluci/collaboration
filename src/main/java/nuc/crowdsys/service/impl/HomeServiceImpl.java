package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.mapper.HomeMapper;
import nuc.crowdsys.service.HomeService;
import nuc.crowdsys.utils.Tree;
import nuc.crowdsys.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.crowdsys.service.impl
 * @Description:
 * @Date: Created in 17:24 2019-05-12
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<SysPermission> findUserMenus(Integer uId) {
        return homeMapper.findUserMenus(uId);
    }

    @Override
    public Tree<SysPermission> getUserMenu(Integer uId) {

        List<Tree<SysPermission>> trees = new ArrayList<>();

        List<SysPermission> menus = findUserMenus(uId);
        menus.forEach(menu -> {
            Tree<SysPermission> tree = new Tree<>();
            tree.setId(menu.getId().toString());
            tree.setParentId(menu.getParentId().toString());
            tree.setText(menu.getName());
            tree.setIcon(menu.getIcon());
            tree.setUrl(menu.getUrl());
            trees.add(tree);
        });
        return TreeUtils.build(trees);
    }
}
