package nuc.crowdsys.entity;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysLog {

    /**
     * 日志id
     */
    private Long logid;

    /**
     * 用户名
     */
    private String username;
    /**
     * 操作模块
     */
    private String module;
    /**
     * 方法描述
     */
    private String methoddescription;
    /**
     * 操作方法
     */
    private String method;
    /**
     * 响应时间
     */
    private String responsedata;
    /**
     * ip地址
     */
    private String ip;
    /**
     * 操作时间
     */
    private String data;
    /**
     * 描述
     */
    private String description;

    /**
     * 请求参数
     */
    private String params;
}