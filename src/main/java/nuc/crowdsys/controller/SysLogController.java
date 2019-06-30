package nuc.crowdsys.controller;


import nuc.crowdsys.annotation.SystemLog;
import nuc.crowdsys.entity.SysLog;
import nuc.crowdsys.service.SysLogService;
import nuc.crowdsys.utils.QueryRequest;
import nuc.crowdsys.utils.ResponseBo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/syslog")
public class SysLogController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysLogService logService;

    @RequestMapping("log")
    @RequiresPermissions("syslog_view")
    public String llog() {
        return "syslog/log";
    }

    @RequestMapping("/list")
    @ResponseBody
    @RequiresPermissions("syslog_view")
    @SystemLog(module = "系统日志管理", methods = "查询所有日志")
    public Map<String, Object> logList(QueryRequest request, SysLog log) {
        return super.selectByPageNumSize(request, () -> this.logService.findAllLogs(log));
    }


    @RequestMapping("/delete")
    @ResponseBody
    @RequiresPermissions("syslog_delete")
    @SystemLog(module = "系统日志管理", methods = "删除日志")
    public ResponseBo deleteLogss(String ids) {
        try {
            this.logService.deleteLogs(ids);
            return ResponseBo.ok("删除日志成功！");
        } catch (Exception e) {
            logger.error("删除日志失败", e);
            return ResponseBo.error("删除日志失败，请联系网站管理员！");
        }
    }
}
