package org.henry.springboot1.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateThymeleafController {

	
	@RequestMapping("/") 
	public String template(Map<String,Object> map){
		
		map.put("hello", "first thymeleaf page");
		return "template";
	}
	
	
	//动态css3
	@RequestMapping("/tools/cssAnimate") 
	public String CssAnimate(Map<String,Object> map){

		return "page/index";
	}
	
	//动态css3
		@RequestMapping("/tools/blank") 
		public String blankPage(Map<String,Object> map){

			return "page/blank";
		}
	
	
	
	
}
