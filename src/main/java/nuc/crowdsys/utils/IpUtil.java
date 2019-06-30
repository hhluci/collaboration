package nuc.crowdsys.utils;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.crowdsys.utils
 * @Description:
 * @Date: Created in 18:30 2019-06-29
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取IP地址和机器名
 */
public class IpUtil {

    /**
     * 获取本机的IP地址
     *
     * @return
     * @throws UnknownHostException
     */
    public static String getLocalIP() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        return addr.getHostAddress();
    }

    /**
     * 获取本机的机器名
     *
     * @return
     * @throws UnknownHostException
     */
    public static String getLocalHostName() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        return addr.getHostName();
    }

    /**
     * 根据域名获得主机的IP地址
     *
     * @param hostName 域名
     * @return
     * @throws UnknownHostException
     */
    public static String getIPByName(String hostName)
            throws UnknownHostException {
        InetAddress addr = InetAddress.getByName(hostName);
        return addr.getHostAddress();
    }

    /**
     * 根据域名获得主机所有的IP地址
     *
     * @param hostName 域名
     * @return
     * @throws UnknownHostException
     */
    public static String[] getAllIPByName(String hostName)
            throws UnknownHostException {
        InetAddress[] addrs = InetAddress.getAllByName(hostName);
        String[] ips = new String[addrs.length];
        for (int i = 0; i < addrs.length; i++) {
            ips[i] = addrs[i].getHostAddress();
        }
        return ips;
    }

    public static void main(String[] args) throws UnknownHostException {
        // 获取本机的IP地址和机器名
        System.out.println("Local IP: " + IpUtil.getLocalIP());
        System.out.println("Local HostName: " + IpUtil.getLocalHostName());
    }
}