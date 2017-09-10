package com.hualuo.springmvc.web.ch4_3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hualuo.springmvc.domain.DemoObj;

/**
 * @author Joseph 
 * @date 2017��9��10��  ����3:17:20
 *
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {

	@RequestMapping(value = "/getJson", produces = "application/json;charset=UTF-8")
	public DemoObj getJson(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "gg");
	}
	
	@RequestMapping(value = "/getXml", produces = "application/xml;charset=UTF-8")
	public DemoObj getXML(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "gg");
	}
}
