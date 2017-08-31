package com.zhiyou100.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.model.Admin;
import com.zhiyou100.model.User;

public class CustomInterceptor implements HandlerInterceptor {

	
	
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object obj, Exception ec)
			throws Exception {
		/*System.out.println("视图渲染显示后调用,可查看日志,清理一些资源");*/
		
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView mv)
			throws Exception {
		/*System.out.println("controller执行后调用,参数是req和res,controller对象和数据视图,"
				+ "可以对数据进行处理");*/

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		
	/*	System.out.println("controller执行前调用,参数是req,res,controller对象,只有返回true,"
				+ "才可以继续,用来做用户登录验证和权限校验"+obj);*/
		
		 @SuppressWarnings("unchecked")
			List<Admin> role = (List<Admin>) req.getSession().getAttribute("adminList");
			   System.out.println("路径:" +req.getServletPath());

			   
	  
			  if(req.getSession().getAttribute("adminList")!=null){
				  return true;
			  }else{
				res.sendRedirect(req.getContextPath()+"/index.jsp");
				
				return false;
				
			  }
			 
			
			  
			
			
		
	}

}
