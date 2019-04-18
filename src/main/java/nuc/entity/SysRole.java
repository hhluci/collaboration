package nuc.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysRole {
    private Integer roleId;

    private String roleName;

    private String roleDescription;

    private Boolean rolePrivLevel;

}