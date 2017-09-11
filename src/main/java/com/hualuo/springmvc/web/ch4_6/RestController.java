package com.hualuo.springmvc.web.ch4_6;

import com.hualuo.springmvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Joseph
 * @create 2017/9/11 23:35
 */
@Controller
public class RestController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/testRest", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String testRest() {
        return demoService.saySomthing();
    }
}
