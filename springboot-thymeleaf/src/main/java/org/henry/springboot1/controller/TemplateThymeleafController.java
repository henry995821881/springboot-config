package org.henry.springboot1.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateThymeleafController {

	
	@RequestMapping("/template/index") 
	public String index(Map<String,Object> map){
		
		map.put("hello", "first thymeleaf page");
		return "/index";
	}
}
