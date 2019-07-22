package nuc.crowdsys.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.crowdsys.entity
 * @Description:
 * @Date: Created in 10:15 2019-07-22
 */
@Data
@ToString
public class FlowProcess {
    //流程定义ID
    private String id;

    //流程定义的名称
    private String name;

    //流程定义的key
    private String key;

    //流程定义的版本
    private int version;

    //资源名称bpmn文件
    private String resourceName;

    //资源名称png文件
    private String diagramResourceName;

    //部署对象ID
    private String deploymentId;


}
