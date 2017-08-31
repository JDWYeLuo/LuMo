package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.User;

public interface FrontService {

	boolean registUser(User u);
	
	List<User> frontLogin(User u);

	List<User> selectAll();

	User findPerson(Integer i);

	void updatePerson(User u);

	

	void updateUser(User user);

	User findUserById(Integer id);

	void updateUserHead(User u);

	List<User> selectPwd(User u);

	void updatePwd(User u);

	int oldPwd(User u);

	User sendEmail(String email);

	List<User> compareCaptcha(User user);

	void resetpwd(User u);

	


	
}
