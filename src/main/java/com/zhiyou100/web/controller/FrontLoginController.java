package com.zhiyou100.web.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.model.User;
import com.zhiyou100.model.UserVO;
import com.zhiyou100.service.FrontService;




@Controller

public class FrontLoginController {

	@Autowired
	FrontService fs;
	
	
	@RequestMapping(value="/front/user/noseLogin.action")
	public String login(){
		
		return "/front/index";
		
	}
	
	
	//注册
	@RequestMapping(value="/front/user/regist.action")
	@ResponseBody
	public User  registUser(String email,String password,HttpSession session){
		
		User u = new User();
		
		u.setEmail(email);
		
		u.setPassword(password);
		
		boolean b = fs.registUser(u);
		
		u.setSuccess(b);
		
		u.setMessage("用户已存在,请重新注册");
		
		/*session.setAttribute("_front_user", u); */
		return u;
		
	}
	
	//登录
	@RequestMapping(value="/front/user/login.action")
	@ResponseBody
	public User loginFront( User u,Model md,HttpSession session){
		
		List<User> list = fs.frontLogin(u);
		
		
		/*System.out.println(list.isEmpty());*/
		
		 if ( list.isEmpty()==false) {
	    	  md.addAttribute("list", list);
	    	
	    	  u=list.get(0);
	    	session.setAttribute("_front_user", u);   
		  }else {
			u.setId(0);  
		    } 
		return u;
	}
	
	//列表
	@RequestMapping(value="/front/user/index.action")
	public String personHeader(User u,Model md,HttpSession session){
		User user =(User) session.getAttribute("_front_user");

    	md.addAttribute("user", user);
		
		return "/front/user/index";
		
	}
	
	
	//修改资料
	@RequestMapping(value="/front/user/profile.action",method=RequestMethod.GET)
	public String updatePerson(
			Model md,HttpSession session){
		
		User user = (User) session.getAttribute("_front_user");
		
		if(user.getBirthday()!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			String str=sdf.format(user.getBirthday());
			user.setBirthdayStr(str);
			
		}
		
		
		
		
		md.addAttribute("user", user);
		
		return "/front/user/profile";
		
	}
	
	@RequestMapping(value="/front/user/profile.action",method=RequestMethod.POST)
	public String updatePerson02(User user,
			Model md,HttpSession session){
		User u = (User) session.getAttribute("_front_user");
		user.setId(u.getId());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=sdf.parse(user.getBirthdayStr());
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		user.setBirthday(date);
		fs.updateUser(user);
		
		User us = fs.findUserById(u.getId());
		session.setAttribute("_front_user",us);
		
		return "redirect:/front/user/index.action";
		
	}
	//添加图片
	@RequestMapping(value="/front/user/avatar.action",method=RequestMethod.GET)
	public String updateHead(
			Model md,HttpSession session){
		
		User uu = (User) session.getAttribute("_front_user"); 
		
		md.addAttribute("user", uu);
		

		return "/front/user/avatar";
	}
	
	@RequestMapping(value="/front/user/avatar.action",method=RequestMethod.POST)
	public String updateHead02(MultipartFile image_file,HttpServletRequest req,
			HttpSession session) {
		
		String extendName = FilenameUtils.getExtension(image_file.getOriginalFilename());
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String fileName = name+"."+extendName;
		String picUrl = "D:\\upload";
		try {
			image_file.transferTo(new File(picUrl+"\\"+fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int id = ((User)session.getAttribute("_front_user")).getId();
		/*User u = (User) session.getAttribute("_front_user");*/
		
		User u = new User();
		u.setHeadUrl(fileName);
		u.setId(id);
		
		fs.updateUser(u);
		
		User us = fs.findUserById(u.getId());
		
		session.setAttribute("_front_user",us);
		
		return "redirect:/front/user/index.action";
		
		
	}
	
	//修改密码
	@RequestMapping(value="/front/user/password.action",method=RequestMethod.GET)
	public String updateOldPassword(
			Model md,HttpSession session){
		
		User uu = (User) session.getAttribute("_front_user"); 
		
		md.addAttribute("user", uu);
		

		return "/front/user/password";
		
	}
	
	
	
	@RequestMapping(value="/front/user/password.action",method=RequestMethod.POST)
	
	public String updatePassword(Model md,HttpSession session,
            String newPassword){
		
		User uu = (User) session.getAttribute("_front_user"); 
		
		User u = new User();
		u.setId(uu.getId());
		u.setPassword(newPassword);
		fs.updatePwd(u);
		
		
		session.setAttribute("_front_user", "");
		
	
		return "redirect:/front/user/noseLogin.action";
	}
	
	
	@RequestMapping(value="/front/user/ajax.action")
	@ResponseBody
	public String oldPwd(String oldPwd,HttpSession session){
		int id=((User) session.getAttribute("_front_user")).getId();
		User u =new User();
		u.setId(id);
		u.setPassword(oldPwd);
		int a = fs.oldPwd(u);
		String s =null;
		if(a==0){
			s ="密码不正确!";
		}else{
			s="success";
		}
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//退出
	@RequestMapping(value="/front/user/logout.action")
	public String logout(
			Model md,HttpSession session){
		
		session.setAttribute("_front_user",""); 
		

		return "redirect:/front/user/noseLogin.action";
		
	}
	
	
	//忘记密码
	@RequestMapping(value="/front/user/forgetpwd.action")
	public String forgetpwd(){
		

		return "/front/user/forget_pwd";
		
	}
	

		//通过ajax提交邮箱并向邮箱发送验证码
		@RequestMapping("/front/user/sendemail.action")
		@ResponseBody
		public User sendemail(String email){
			return fs.sendEmail(email);
	}
		
		//比对验证码
		@RequestMapping(value="/front/user/forgetpwd.action",method=RequestMethod.POST)
		public String compareCaptcha(User user,Model model){
			List<User> list= fs.compareCaptcha(user);
			if(list.isEmpty()){
				model.addAttribute("mes", "验证码错误");
				model.addAttribute("email", user.getEmail());
				return "/front/user/forget_pwd";
			}
			model.addAttribute("email", user.getEmail());
			model.addAttribute("captcha", user.getCaptcha());
			return "/front/user/reset_pwd";
		}
		
		
		
		//重置密码
		@RequestMapping("/front/user/resetpwd.action")
		public String resetpwd(User u){
			
			fs.resetpwd(u);
			
			return "redirect:/front/user/noseLogin.action";
			
		}
	
	

	
	
}