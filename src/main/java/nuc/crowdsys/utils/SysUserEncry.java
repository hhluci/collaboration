package nuc.crowdsys.utils;

import nuc.crowdsys.entity.SysUser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.crowdsys.utils
 * @Description:
 * @Date: Created in 18:22 2019-04-25
 */
public  class SysUserEncry {
    //随机数生成器
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    //指定散列算法为md5
    private static String algorithmName = "MD5";
    //散列迭代次数
    private static final int hashIterations = 2;

    public static SysUser encry(SysUser sysUser){
        sysUser.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword =
                new SimpleHash(algorithmName,sysUser.getPassword(),
                        ByteSource.Util.bytes(sysUser.getCredentialsSalt()),hashIterations).toHex();

        sysUser.setPassword(newPassword);
        return sysUser;
    }
}
