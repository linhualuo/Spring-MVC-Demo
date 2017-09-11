package com.hualuo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joseph 
 *
 */
@Controller
public class HelloController {

	@RequestMapping("/index")
	public String hello() {
		return "index";
	}
}
