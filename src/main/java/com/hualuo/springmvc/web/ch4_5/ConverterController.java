package com.hualuo.springmvc.web.ch4_5;

import com.hualuo.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Joseph
 * @create 2017/9/11 14:51
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/convert", produces = {"application/x-hualuo"})
    @ResponseBody
    public DemoObj converter(@RequestBody DemoObj obj) {
        return obj;
    }
}
