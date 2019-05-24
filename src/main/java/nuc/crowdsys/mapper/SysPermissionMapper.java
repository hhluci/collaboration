package nuc.crowdsys.mapper;


import nuc.crowdsys.entity.SysPermission;

import java.util.List;

public interface SysPermissionMapper {

    List<SysPermission> findAllSysPermissions();

    List<SysPermission> findAllMenus(SysPermission menu);

    void addPermission(SysPermission menu);

    void deleteById(long id);

    // 删除父节点，子节点变成顶级节点
    void changeToTop(List<String> menuids);

    SysPermission findById(Long menuId);

    void updatePermission(SysPermission menu);
}