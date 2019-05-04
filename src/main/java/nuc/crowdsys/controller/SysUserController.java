package nuc.crowdsys.controller;

import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static nuc.crowdsys.utils.SysUserEncry.encry;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.controller
 * @Description:
 * @Date: Created in 14:26 2019-04-25
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/findAllUsers")
    public String findAllRoles(Model model) {
        List<SysUser> allUsers = sysUserService.findAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "sysuser/usermanage";
    }

    @GetMapping("/adduser")
    public String addUser() {
        return "sysuser/adduser";
    }

    @PostMapping("/toAddUser")
    public String toAddUser(String username, String name, String password, Model model) {

        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setName(name);
        sysUser.setPassword(password);
        sysUser.setState((byte) 0);

        sysUser = encry(sysUser);

        int msg = sysUserService.addUser(sysUser);
        System.out.println(msg);
        if (msg > 0) {
            model.addAttribute("msg", "添加成功！");

        } else {
            model.addAttribute("msg", "添加失败！");
        }
        return "sysuser/adduser";
    }

    @RequestMapping("/delete")
    public String deleteByUid(String uid, Model model) {
        int msg = sysUserService.deleteByUid(Integer.parseInt(uid));
        if (msg > 0) {
            model.addAttribute("msg", "操作成功！");
        } else {
            model.addAttribute("msg", "操作失败！");
        }
        return "sysuser/userstate";
    }

    @RequestMapping("/toUpdate")
    public String updateByUid(String uid, Model model) {
        SysUser sysUser = sysUserService.findByUid(Integer.parseInt(uid));
        model.addAttribute("sysUser", sysUser);

        return "sysuser/updateuser";
    }

    @RequestMapping("/update")
    public String update(String uid, String username, String name, String password, String state, Model model) {
        SysUser sysUser = new SysUser();
        sysUser.setUid(Integer.parseInt(uid));
        sysUser.setUsername(username);
        sysUser.setName(name);
        sysUser.setPassword(password);
        sysUser.setState((byte) (Integer.parseInt(state)));
        sysUser = encry(sysUser);
        int msg = sysUserService.updateSysUser(sysUser);
        if (msg > 0) {
            model.addAttribute("msg", "操作成功！");
        } else {
            model.addAttribute("msg", "操作失败！");
        }
        return "sysuser/userstate";
    }


    //批量删除
    @RequestMapping("/batchdelete")
    public String batchDelete(String tag, Model model) {
        String[] strs = tag.split(",");
        List<String> msgs = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            try {
                int msg = sysUserService.deleteByUid(Integer.parseInt(strs[i]));
                if (msg > 0) {
                    msgs.add("id为： " + strs[i] + " 删除成功！");
                } else {
                    msgs.add("id为： " + strs[i] + " 删除失败！");
                }
            } catch (Exception e) {
            }
        }
        model.addAttribute("msg", msgs);
        return "sysuser/userstate";
    }
}
