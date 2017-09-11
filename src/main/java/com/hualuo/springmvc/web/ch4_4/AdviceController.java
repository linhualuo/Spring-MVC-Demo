package com.hualuo.springmvc.web.ch4_4;

import com.hualuo.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 演示控制器
 *
 * @author Joseph
 * @create 2017/9/11 13:15
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomthing(@ModelAttribute("msg") String msg, DemoObj obj) {
        throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModelAttribute: " + msg);
    }
}
