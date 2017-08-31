package com.zhiyou100.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.model.User;
import com.zhiyou100.model.UserExample;
import com.zhiyou100.service.FrontService;
import com.zhiyou100.util.MailUtil;
@Service
public class FrontServiceImpl implements FrontService {
	
	@Autowired
	UserMapper um;
	
	
	@Override
	public boolean registUser(User u) {
		
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail());
		List<User> list = um.selectByExample(ue);
		if(list.isEmpty()){
			u.setInsertTime(new Timestamp(System.currentTimeMillis()));
			um.insertSelective(u);
			return true;
		}
		
		return false;
	}
	
	@Override
	public List<User> frontLogin(User u) {
		UserExample ue = new UserExample();
		
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andPasswordEqualTo(u.getPassword());
		
		List<User> se = um.selectByExample(ue);
		
		
		return se;
	}

	@Override
	public List<User> selectAll() {
		
		return um.selectByExample(null);
	}

	@Override
	public User findPerson(Integer id) {
		
		return um.selectByPrimaryKey(id);
	}

	@Override
	public void updatePerson(User u) {
		u.setUpdateTime(new Timestamp(System.currentTimeMillis()));

		um.updateByPrimaryKeySelective(u);
		
	}

	@Override
	public void updateUserHead(User u) {
		
		um.updateByPrimaryKeySelective(u);
	}

	@Override
	public void updateUser(User user) {
		user.setUpdateTime(new Timestamp(System.currentTimeMillis()));

		um.updateByPrimaryKeySelective(user);
		
	}

	@Override
	public User findUserById(Integer id) {
		
		return um.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectPwd(User u) {
		
		return um.findOldPassword();
	}

	@Override
	public void updatePwd(User u) {
		um.updatePwd(u);
		
	}

	@Override
	public int oldPwd(User u) {
		
		return um.findOldPwd(u);
	}

	
	
	
	@Override
	public User sendEmail(String email) {
		User user = new User();
		Random ra =new Random();
		int a =ra.nextInt(90000)+10000;
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email);
		List<User> list = um.selectByExample(ue);
		if(list.isEmpty()){
			user.setSuccess(false);
			user.setMessage("邮箱不正确,请输入正确的已注册邮箱");
		}else{
			try {
				MailUtil.send(email, "验证码", ""+a);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			user.setEmail(email);
			user.setCaptcha(""+a);
			um.insertCaptcha(user);
			user.setSuccess(true);
		}
		return user;
	}

	@Override
	public List<User> compareCaptcha(User user) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(user.getEmail()).andCaptchaEqualTo(user.getCaptcha());
		return um.selectByExample(ue);
	}

	@Override
	public void resetpwd(User u) {
		um.resetpwd(u);
		
	}

	

}
