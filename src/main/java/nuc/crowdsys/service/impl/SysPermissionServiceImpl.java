package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.entity.SysRole;
import nuc.crowdsys.mapper.SysPermissionMapper;
import nuc.crowdsys.mapper.SysRoleMapper;
import nuc.crowdsys.mapper.SysRolePermissionMapper;
import nuc.crowdsys.service.SysPermissionService;
import nuc.crowdsys.service.SysRoleService;
import nuc.crowdsys.utils.Tree;
import nuc.crowdsys.utils.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.service.impl
 * @Description:
 * @Date: Created in 14:34 2019-04-17
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;


    @Override
    public List<SysPermission> findAllMenus(SysPermission menu) {
        try {

            return sysPermissionMapper.findAllMenus(menu);
        } catch (NumberFormatException e) {
            log.error("error", e);
            return new ArrayList<>();
        }
    }

    @Override
    public Tree<SysPermission> getMenuTree() {
        List<Tree<SysPermission>> trees = new ArrayList<>();

        SysPermission menu = new SysPermission();
        menu.setType("0");
        List<SysPermission> menus = sysPermissionMapper.findAllMenus(menu);

        buildTrees(trees, menus);
        return TreeUtils.build(trees);
    }


    private void buildTrees(List<Tree<SysPermission>> trees, List<SysPermission> menus) {
        menus.forEach(menu -> {
            Tree<SysPermission> tree = new Tree<>();
            tree.setId(menu.getId().toString());
            tree.setParentId(menu.getParentId().toString());
            tree.setText(menu.getName());
            trees.add(tree);
        });
    }


    @Override
    public SysPermission findByNameAndType(String name, String type) {

        SysPermission menu = new SysPermission();
        menu.setName(name.toLowerCase());
        menu.setType(type);

        List<SysPermission> list = sysPermissionMapper.findAllMenus(menu);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void addMenu(SysPermission menu) {

        if (menu.getParentId() == null)
            menu.setParentId(0L);
        if ("1".equals(menu.getType())) {
            menu.setUrl(null);
            menu.setIcon(null);
        }
        sysPermissionMapper.addPermission(menu);
    }

    @Override
    public void deleteMeuns(String menuIds) {
        List<String> list = Arrays.asList(menuIds.split(","));
        //根据id批量删除权限并删除角色权限绑定
        for (String id : list) {
            sysPermissionMapper.deleteById(Long.parseLong(id));
            sysRolePermissionMapper.deleteRolePermisssionsByPId(Long.parseLong(id));
        }

        sysPermissionMapper.changeToTop(list);
    }

    @Override
    public SysPermission findById(Long menuId) {
        return sysPermissionMapper.findById(menuId);
    }

    @Override
    public void updateMenu(SysPermission menu) {

        if (menu.getParentId() == null)
            menu.setParentId(0L);
        if ("1".equals(menu.getType())) {
            menu.setUrl(null);
            menu.setIcon(null);
        }
        sysPermissionMapper.updatePermission(menu);
    }
}
