package nuc.crowdsys.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class RoleWithMenu extends SysRole {

    private Long permissionId;

    private List<Long> permissionIds;


}
