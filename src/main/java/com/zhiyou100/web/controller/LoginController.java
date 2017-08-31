package com.zhiyou100.web.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.model.Admin;
import com.zhiyou100.service.LoginService;

@Controller
@RequestMapping("/admin")
public class LoginController {
	@Autowired
	LoginService ls;
	
	
	
	@RequestMapping("/login/indexLogin.action")
	public String indexLogin(String loginName,String loginPwd,ModelMap mp, HttpServletRequest req,
			HttpServletResponse res,HttpSession session) throws Exception{
		
		List<Admin> adminList = ls.loginIndex(loginName,loginPwd);
		
		if(adminList.isEmpty()){
			req.setAttribute("errorMessage", "用户名密码不匹配");
			req.getRequestDispatcher("/index.jsp").forward(req, res);
		}
		
		session.setAttribute("adminList", adminList);
		
		
		return "redirect:/admin/video/videoOrganizer.action";
		
	}
	
	
	
	/*public static String getMD5(String loginPwd) throws Exception {
	    try {
	        // 生成一个MD5加密计算摘要
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        // 计算md5函数
	        md.update(loginPwd.getBytes());
	        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	        return new BigInteger(1, md.digest()).toString(16);
	        
	    } catch (Exception e) {
	        throw new Exception("MD5加密出现错误");
	    }
	}*/
	
	
}
