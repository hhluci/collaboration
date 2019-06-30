package nuc.crowdsys.controller;

import nuc.crowdsys.annotation.SystemLog;
import nuc.crowdsys.entity.SysPermission;
import nuc.crowdsys.service.MenuService;
import nuc.crowdsys.utils.ResponseBo;
import nuc.crowdsys.utils.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuService menuService;

    @RequestMapping("menu/getUserMenu")
    @ResponseBody
    @SystemLog(module = "系统菜单模块", methods = "获取菜单")
    public ResponseBo getUserMenu(Integer userId) {
        try {
            Tree<SysPermission> tree = menuService.getUserMenu(userId);
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            logger.error("获取用户菜单失败", e);
            return ResponseBo.error("获取用户菜单失败！");
        }
    }

    @RequestMapping("menu/menuButtonTree")
    @ResponseBody
    public ResponseBo getMenuButtonTree() {
        try {
            Tree<SysPermission> tree = this.menuService.getMenuButtonTree();
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            logger.error("获取菜单列表失败", e);
            return ResponseBo.error("获取菜单列表失败！");
        }
    }


}
