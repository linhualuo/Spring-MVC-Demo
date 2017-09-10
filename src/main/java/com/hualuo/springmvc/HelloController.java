package com.hualuo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joseph 
 * @date 2017��9��9��  ����9:53:32
 *
 */
@Controller
public class HelloController {

	@RequestMapping("/index")
	public String hello() {
		return "index";
	}
}
