package com.hualuo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joseph 
 * @date 2017年9月9日  下午9:53:32
 *
 */
@Controller
public class HelloController {

	@RequestMapping("/index")
	public String hello() {
		return "index";
	}
}
