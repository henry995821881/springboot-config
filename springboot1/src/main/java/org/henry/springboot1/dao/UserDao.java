package org.henry.springboot1.dao;

import java.util.List;

import org.henry.springboot1.bean.User;


public interface UserDao {

	
	
	List<User> getUser();
	
	void setUser(User user);
}
