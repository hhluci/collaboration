package nuc.crowdsys.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysRolePermission {
    private Long permissionId;
    private Long roleId;
}
