package com.hualuo.springmvc.web.ch4_3;

import com.hualuo.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Joseph 
 *
 */
@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) {
		return "url: " + request.getRequestURI() + " can access";
	}
	
	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
		return "url: " + request.getRequestURI() + " can access, str: " + str;
	} 
	
	@RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(long id, HttpServletRequest request) {
		return "url: " + request.getRequestURI() + " can access, id: " + id;
	}
	
	@RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String passObj(DemoObj demoObj, HttpServletRequest request) {
		return "url: " + request.getRequestURI() + " can access, obj id: " + demoObj.getId() + 
				", obj name: " + demoObj.getName();
	}
	
	@RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {
		return "url: " + request.getRequestURI() + " can access";
	}
}
