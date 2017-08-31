package com.zhiyou100.web.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.model.User;

public class FrontInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, 
			    Object handler)
			throws Exception {
		
		
		       User user =(User) req.getSession().getAttribute("_front_user");
			   System.out.println("路径:" +req.getServletPath());

			   
	  
			  if(req.getSession().getAttribute("_front_user")!=null){
				  return true;
			  }else{
				res.sendRedirect(req.getContextPath()+"/front/user/noseLogin.action");
				
				return false;
			  }
		
	
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		

	}

}
