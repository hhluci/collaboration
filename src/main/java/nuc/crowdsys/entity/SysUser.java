package nuc.crowdsys.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysUser {
    private Integer uid;
    private String username;//帐号
    private String name;//名称（昵称或者真实姓名）
    private String password; //密码;
    private String salt;//加密密码的盐
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）待验证的用户 , 1:正常状态,2：用户被锁定.

    /**
     * 密码盐.
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }

}
