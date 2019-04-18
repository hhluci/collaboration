package nuc.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class SysUser {
    private Integer userId;

    private String userName;

    private String loginPassword;

    private Integer rolePrivLevel;

    private Integer roleId;

    private Boolean ifOnline;

    private Boolean isLocked;

    private Date userExpired;

    private String userMobile;

    private String userEmail;

    }
