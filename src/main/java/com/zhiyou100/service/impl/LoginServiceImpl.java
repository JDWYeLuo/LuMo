package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.AdminMapper;
import com.zhiyou100.model.Admin;
import com.zhiyou100.model.AdminExample;
import com.zhiyou100.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	AdminMapper am;
	
	@Override
	public List<Admin> loginIndex(String loginName, String loginPwd) {
		
		AdminExample ae = new AdminExample();
		
		ae.createCriteria().andLoginNameLike(loginName).andLoginPwdLike(loginPwd);
		
	
		return am.selectByExample(ae);
	}

}
