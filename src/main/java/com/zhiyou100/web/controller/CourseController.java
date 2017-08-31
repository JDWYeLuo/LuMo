package com.zhiyou100.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;
import com.zhiyou100.service.CourseService;
import com.zhiyou100.util.Page;






@Controller
@RequestMapping("/admin")
public class CourseController {
	
	@Autowired
	CourseService cs;
	
	 @RequestMapping("/course/listCourse.action")
	public String speakerList( HttpServletRequest req,Model md,
			@RequestParam(value="page" ,required=false,defaultValue="1")Integer currentPage){
		
   		Page  page = cs.listCourse(currentPage);
		
		/*System.out.println("page:"+page);*/
		req.setAttribute("page", page);
		
		return "/course/CourseList";
		
	}
	 
	 
	 @RequestMapping(value="/course/addCourse.action",method=RequestMethod.GET)
		public String courseAdd(HttpServletRequest req){
			
		 List<Subject> subject = cs.findSubject();
		 
		 req.setAttribute("subject", subject);
		 
			return "/course/CourseAdd";
		}
		
		@RequestMapping(value="/course/addCourse02.action",method=RequestMethod.POST)
		public String courseAdd02(Course ce){
			
			cs.addCourse(ce);
			
			return "redirect:/admin/course/listCourse.action";
		}
	 
		@RequestMapping("/course/deleteCourse.action")
		public String courseDelete(Integer id){
			
			cs.deleteCourse(id);
			
			return "redirect:/admin/course/listCourse.action";
		}
	 
		@RequestMapping(value="/course/updateCourse.action",method=RequestMethod.GET)
		public String courseUpdate(Integer id,HttpServletRequest req){
			
			List<Subject> subject = cs.findSubject();
			 
			 req.setAttribute("subject", subject);
			
			Course ce = cs.updateCourse(id);
			req.setAttribute("course", ce);
			
			return "/course/CourseUpdate";
		}
		@RequestMapping(value="/course/updateCourse02.action",method=RequestMethod.POST)
		public String courseUpdate02(Course ce){
		
			cs.updateCourseView(ce);
		
			return "redirect:/admin/course/listCourse.action";
			
		}
		
		
		/*@RequestMapping("/course/viewList.action")
		public String courseView(){
			
			System.out.println(123321);
			
			return "/course/listView";
															
		}*/
		
		
		
		
}
