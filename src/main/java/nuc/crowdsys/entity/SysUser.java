package nuc.crowdsys.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class SysUser implements Serializable {
    private Long uid;
    private String username;//帐号
    private String name;//名称（昵称或者真实姓名）
    private String password; //密码;
    private String salt;//加密密码的盐

    private String state;//用户状态,0=锁定,1=有效

    /**
     * 密码盐.
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }

}
