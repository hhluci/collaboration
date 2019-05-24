package nuc.crowdsys.entity;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysRole {
    private Long id; // 编号
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用
    private String state;//用户状态,0=锁定,1=有效
}