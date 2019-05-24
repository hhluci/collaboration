package nuc.crowdsys.mapper;

import nuc.crowdsys.entity.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.crowdsys.mapper
 * @Description:
 * @Date: Created in 17:27 2019-05-12
 */
public interface MenuMapper {
    @Select("SELECT * FROM sys_permission p WHERE p.id IN (" +
            "SELECT rp.permission_id FROM sys_role_permission rp WHERE rp.role_id IN(" +
            "SELECT ur.role_id FROM sys_user_role ur WHERE ur.uid = #{uId} )) and p.type='0'")
    List<SysPermission> findUserMenus(@Param("uId") Integer uId);

    @Select("select * from sys_permission")
    List<SysPermission> findAllMenus();

}
