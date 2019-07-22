package nuc.crowdsys.service.impl;

import nuc.crowdsys.entity.FlowProcess;
import nuc.crowdsys.service.ActivitiService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service("ActiviService")
public class ActivitiServiceImpl implements ActivitiService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<FlowProcess> selAllactiviti(FlowProcess flowProcess) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        try {
            if (StringUtils.isNotBlank(flowProcess.getKey())) {
                List<ProcessDefinition> list = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                        .createProcessDefinitionQuery()//创建一个流程定义的查询
                        .processDefinitionKey(flowProcess.getKey())//使用流程定义的key查询
                        /**排序*/
                        .orderByProcessDefinitionVersion().asc()//按照版本的升序排列

                        /**返回的结果集*/
                        .list();
                List<FlowProcess> proList = Transformation(list);
                return proList;
            } else {
                List<ProcessDefinition> list = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                        .createProcessDefinitionQuery()//创建一个流程定义的查询
                        /**排序*/
                        .orderByProcessDefinitionVersion().asc()//按照版本的升序排列
                        /**返回的结果集*/
                        .list();//返回一个集合列表，封装流程定义
                List<FlowProcess> proList = Transformation(list);
                return proList;
            }
        } catch (Exception e) {
            log.error("获取流程部署信息失败", e);
            return new ArrayList<>();
        }
    }

    public List<FlowProcess> Transformation(List<ProcessDefinition> list) {
        List<FlowProcess> proList = new ArrayList<>();
        if (list != null && list.size() > 0) {

            for (ProcessDefinition pd : list) {
                FlowProcess Process = new FlowProcess();
                Process.setId(pd.getId());
                Process.setName(pd.getName());
                Process.setKey(pd.getKey());
                Process.setVersion(pd.getVersion());
                Process.setResourceName(pd.getResourceName());
                Process.setDiagramResourceName(pd.getDiagramResourceName());
                Process.setDeploymentId(pd.getDeploymentId());
                proList.add(Process);
            }
            return proList;
        }
        return proList;
    }


    @Override
    public void activitiInsert(String fname) throws IOException {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //打包后使用路径
        //String dataFolder = "\\temp\\";
        //ApplicationHome home = new ApplicationHome(getClass());
        //File jarFile = home.getSource();
        //String fileName = jarFile.getParentFile().getAbsolutePath() + dataFolder;
        String fileName = "D:\\github\\collaboration\\activitifile\\";


        InputStream in = new FileInputStream(fileName + fname);
        //ZipInputStream zipInputStream = new ZipInputStream(in);
        //获得一个构建器对象，用于加载流程定义的文件 完成流程定义的部署

        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                //.addZipInputStream(zipInputStream)
                .addInputStream(fname, in)
                .name(fname)
                .category(fname)
                .deploy();

        in.close();

    }
}
