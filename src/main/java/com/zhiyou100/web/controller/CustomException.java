package com.zhiyou100.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object obj,
			Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", obj);
		mv.addObject("exception", exception);
		/*mv.setViewName("role/error");*/
		
		
		
		
		return null;
	}

}
