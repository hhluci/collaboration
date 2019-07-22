package nuc.crowdsys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nuc.crowdsys.annotation.SystemLog;
import nuc.crowdsys.entity.FlowProcess;
import nuc.crowdsys.service.ActivitiService;
import nuc.crowdsys.utils.QueryRequest;
import nuc.crowdsys.utils.ResponseBo;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.controller
 * @Description:
 * @Date: Created in 14:26 2019-04-25
 */
@Controller
@RequestMapping("/workflow")
public class WorkFlowController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActivitiService activitiService;

    @RequestMapping("/workflow")
    public String index() {
        return "workflow/workflow";
    }


    @RequestMapping("/list")
    @SystemLog(module = "工作流管理", methods = "查看所有工作流")
    @ResponseBody
    public Map<String, Object> selAllactiviti(QueryRequest request, FlowProcess flowProcess) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        PageInfo<FlowProcess> pageInfo = new PageInfo<>(activitiService.selAllactiviti(flowProcess));
        PageHelper.clearPage();
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    @RequestMapping("/delete")
    @ResponseBody
    @SystemLog(module = "工作流管理", methods = "删除工作流程")
    public ResponseBo deleteDicts(String allkey) {
        try {
            List<String> list = Arrays.asList(allkey.split(","));

            ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
            //删除流程定义
            for (String key : list) {
                List<ProcessDefinition> allList = processEngine.getRepositoryService()//
                        .createProcessDefinitionQuery()//
                        .processDefinitionKey(key)//使用流程定义的key查询
                        .list();
                //遍历，获取每个流程定义的部署ID
                if (list != null && list.size() > 0) {
                    for (ProcessDefinition pd : allList) {
                        //获取部署ID
                        String deploymentId = pd.getDeploymentId();
                        processEngine.getRepositoryService()//
                                .deleteDeployment(deploymentId, true);
                    }
                }
            }
            return ResponseBo.ok("删除工作流程成功！");
        } catch (Exception e) {
            log.error("删除工作流程失败", e);
            return ResponseBo.error("删除工作流程失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/actInsert")
    @ResponseBody
    public ResponseBo actInsert(@RequestParam("workflow") MultipartFile workflow) {

        if (workflow.isEmpty()) {
            return ResponseBo.error("上传文件不能空！请选择文件");
        }
        //打包后使用路径
        //String dataFolder = "\\temp\\";
        //ApplicationHome home = new ApplicationHome(getClass());
        //File jarFile = home.getSource();
        //String AbsoluteDataFolder = jarFile.getParentFile().getAbsolutePath() + dataFolder;
        //System.out.println(AbsoluteDataFolder);

        String AbsoluteDataFolder = "D:\\github\\collaboration\\activitifile\\";

        String fileName = workflow.getOriginalFilename();

        File dest = new File(AbsoluteDataFolder + fileName);

        try {
            workflow.transferTo(dest);
            activitiService.activitiInsert(fileName);
            return ResponseBo.ok("部署工作流程成功！");
        } catch (IOException e) {
            return ResponseBo.error("部署失败，请联系网站管理员！");
        }
    }


    @RequestMapping("/start")
    @ResponseBody
    public ResponseBo startProcesses(String key) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //获取与正在执行的流程示例和执行对象相关的Service
        ProcessInstance processInstance = processEngine.getRuntimeService()
                //使用流程定义的key启动实例，key对应bpmn文件中id的属性值，默认按照最新版本流程启动
                .startProcessInstanceByKey(key);
        log.info("启动流程实例: " + key);
        return ResponseBo.ok("成功启动流程实例: " + key);

    }


}
