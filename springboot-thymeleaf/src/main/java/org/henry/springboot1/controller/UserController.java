package org.henry.springboot1.controller;

import java.util.List;

import org.henry.springboot1.bean.User;
import org.henry.springboot1.dao.UserDao;
import org.henry.springboot1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserDao userDao;
	
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping("/user")
	public String getUser(){
		List<User> list = userDao.getUser();
		logger.info("---------------hello world");
		
		
	    
		return list.toString();
		
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/user/index")
	public String index(){
		
		userService.saveUser();
		logger.info("---------------index");
		return "index";
		
	}
}
