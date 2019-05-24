package nuc.crowdsys.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserWithRole extends SysUser {


    private Long roleId;

    private List<Long> roleIds;


}