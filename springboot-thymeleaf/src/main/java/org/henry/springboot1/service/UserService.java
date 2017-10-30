package org.henry.springboot1.service;

import org.henry.springboot1.bean.User;
import org.henry.springboot1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	
	@Autowired
	UserDao userDao;
	
	/**
	 * 测试事务
	 */
	public void saveUser(){
		
		User u = new User();
		u.setAge(12);
		u.setDesc("desc12");
		u.setUsername("name");
		
		userDao.setUser(u);
		
		int i=1/0;
		
		
		User u1 = new User();
		u1.setAge(12);
		u1.setDesc("desc12");
		u1.setUsername("name");
		
		userDao.setUser(u1);
	}
}
