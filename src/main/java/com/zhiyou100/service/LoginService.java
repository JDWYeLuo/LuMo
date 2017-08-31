package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Admin;

public interface LoginService {

	List<Admin> loginIndex(String loginName, String loginPwd);

}
