package nuc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jurui
 * @ProjectName: collaboration
 * @Package: nuc.web.controller
 * @Description:
 * @Date: Created in 23:08 2019-04-11
 */

@RestController
@RequestMapping("/user")
public class Hello {
    @RequestMapping("/sss")
    @ResponseBody
    public String hello() {
        System.out.println("进入Conller");
        return "hello!!!!!";
    }
}