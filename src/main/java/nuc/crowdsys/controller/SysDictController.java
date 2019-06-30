package nuc.crowdsys.controller;


import nuc.crowdsys.annotation.SystemLog;
import nuc.crowdsys.entity.SysDict;
import nuc.crowdsys.service.SysDictService;
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
@RequestMapping("/sysdict")
public class SysDictController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysDictService sysDictService;

    @RequestMapping("/dict")
    public String ddict() {
        return "sysdict/dict";
    }

    @RequestMapping("/list")
    @ResponseBody
    @RequiresPermissions("sysdict_view")
    @SystemLog(module = "字典管理", methods = "获取所有字典")
    public Map<String, Object> dictList(QueryRequest request, SysDict dict) {
        return super.selectByPageNumSize(request, () -> this.sysDictService.findAllDicts(dict, request));
    }

    @RequestMapping("/getDict")
    @ResponseBody
    public ResponseBo getDict(Long dictId) {
        try {
            SysDict dict = this.sysDictService.findById(dictId);
            return ResponseBo.ok(dict);
        } catch (Exception e) {
            log.error("获取字典信息失败", e);
            return ResponseBo.error("获取字典信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    @RequiresPermissions("sysdict_add")
    @SystemLog(module = "字典管理", methods = "添加字典")
    public ResponseBo addDict(SysDict dict) {
        try {
            this.sysDictService.addDict(dict);
            return ResponseBo.ok("新增字典成功！");
        } catch (Exception e) {
            log.error("新增字典失败", e);
            return ResponseBo.error("新增字典失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    @RequiresPermissions("sysdict_delete")
    @SystemLog(module = "字典管理", methods = "删除字典")
    public ResponseBo deleteDicts(String ids) {
        try {
            this.sysDictService.deleteDicts(ids);
            return ResponseBo.ok("删除字典成功！");
        } catch (Exception e) {
            log.error("删除字典失败", e);
            return ResponseBo.error("删除字典失败，请联系网站管理员！");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    @RequiresPermissions("sysdict_update")
    @SystemLog(module = "字典管理", methods = "修改字典")
    public ResponseBo updateDict(SysDict dict) {
        try {
            this.sysDictService.updateDict(dict);
            return ResponseBo.ok("修改字典成功！");
        } catch (Exception e) {
            log.error("修改字典失败", e);
            return ResponseBo.error("修改字典失败，请联系网站管理员！");
        }
    }

}
