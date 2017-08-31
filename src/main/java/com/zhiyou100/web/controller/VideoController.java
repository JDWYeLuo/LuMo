package com.zhiyou100.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Video;
import com.zhiyou100.model.VideoRemote;
import com.zhiyou100.model.VideoVO;
import com.zhiyou100.service.VideoService;
import com.zhiyou100.util.Page;

@Controller
@RequestMapping("/admin")
public class VideoController {
	
	@Autowired
	VideoService vs;
	
	
	@RequestMapping("/video/videoOrganizer.action")
	public String VideoOrganizer(String videoKeyTitle,String videoKeynoteSpeaker,
			String videoKeyCourse,
			@RequestParam(defaultValue="0")Integer courseId,
			@RequestParam(defaultValue="0")Integer speakerId, HttpServletRequest req,
			HttpServletResponse res){
		
		
		if(videoKeyTitle == null ){
			videoKeyTitle = ""; 
		}
		/*int speakerId=0;
		if(speakerId1!=null){
			speakerId = Integer.parseInt(speakerId1);
		}
		
		int courseId=0;
		if(courseId1!=null){
			courseId = Integer.parseInt(courseId1);
		}*/
		req.setAttribute("videoKeyTitle", videoKeyTitle);
		req.setAttribute("videoKeynoteSpeaker", videoKeynoteSpeaker);
		req.setAttribute("videoKeyCourse", videoKeyCourse);
		req.setAttribute("speakerId", speakerId);
		req.setAttribute("courseId", courseId);
		
		int currentPage = 1;
		if(req.getParameter("page")!=null){
			currentPage = Integer.parseInt(req.getParameter("page"));
		}
	
		VideoRemote vr = new VideoRemote();
		
		vr.setVideoKeyTitle(videoKeyTitle);
		vr.setSpeakerId(speakerId);
		vr.setCourseId(courseId);
		vr.setVideoKeynoteSpeaker(videoKeynoteSpeaker);
		vr.setVideoKeyCourse(videoKeyCourse);
		vr.setCurrentPage(currentPage);
		
		
		System.out.println(speakerId);
		System.out.println(courseId);
		
		
		Page  page = vs.loadPage(vr);
		
		/*System.out.println("page:"+page);*/
		req.setAttribute("page", page);
		
		List<Video> list = vs.findVideo();
		req.setAttribute("list", list);
		
		List<Speaker> speaker = vs.findSpeaker();
		req.setAttribute("speaker", speaker);
		/*System.out.println(speaker);*/
		
		List<Course> course = vs.findCourse();
		req.setAttribute("course", course);
		/*System.out.println(course);*/
		
		
		return "/video/VideoManager";
		
	}
	
	
	
	@RequestMapping("/video/videoDelete.action")	
	public String deleteVideo(Integer id,ModelMap mp,HttpServletRequest req,
			HttpServletResponse res){
		
		      vs.deleteVideo(id);
	
		
		return "redirect:/admin/video/videoOrganizer.action";
	}
	
	@RequestMapping(value="/video/videoAdd.action",method=RequestMethod.GET)
	public String addVideo(HttpServletRequest req,
			HttpServletResponse res){
		
		List<Speaker> speaker = vs.findSpeaker();
		req.setAttribute("speaker", speaker);
		
		
		List<Course> course = vs.findCourse();
		req.setAttribute("course", course);
		
		
		return "/video/VideoAdd";
	}
	
	
	
	@RequestMapping(value="/video/videoAddTwo.action",method=RequestMethod.POST )
	public String addVideo02(Video vd){
		
		
		vs.addVideo(vd);
		
		return "redirect:/admin/video/videoOrganizer.action";
	}
	
	
	@RequestMapping(value="/video/videoUpdate.action",method=RequestMethod.GET)
	public String updateVideo(Integer id,HttpServletRequest req,
			HttpServletResponse res){
		
		List<Speaker> speaker = vs.findSpeaker();
		req.setAttribute("speaker", speaker);
		
		
		List<Course> course = vs.findCourse();
		req.setAttribute("course", course);
		
		Video vd = vs.updateVideo(id);
		/*System.out.println("vd:"+vd);*/
		req.setAttribute("video", vd);
		
		return "/video/VideoUpdate";
	}
	

	@RequestMapping(value="/video/videoUpdate02.action",method=RequestMethod.POST)
	public String updateVideo02(Video vd){
		
		vs.updateVideoView(vd);
		
		return "redirect:/admin/video/videoOrganizer.action";
	}
	
	
	
	@RequestMapping("/video/deletePage.action")
	public String pageDelete(Integer [] id){
		
		for(Integer integer : id){
			 if (integer!=null) {
				 
					vs.deleteVideo(integer);
					
				}
		
		}
		
		return "redirect:/admin/video/videoOrganizer.action";
		
	}
		
	@RequestMapping("/video/batchDelete.action")
	public String videoBatchDelete(Integer[]checkid){	
		
		//System.out.println(Arrays.toString(checkid));
		vs.batchDelete(checkid);
		return "redirect:/admin/video/list.action";
	}
	
	@RequestMapping("/video/delete.action")
	@ResponseBody
	public String videoDelete(Integer id){		
		
		vs.deleteVideoById(id);
		
		return "success";
	}
	
	
	
	
	
	@RequestMapping("/video/viewList.action")
	public String videoView(Integer id,Model md){
		
		List<Video> list = vs.findVideoAndCourse();
		
		System.out.println("listView中Course的name属性:"+list);
		md.addAttribute("list", list);
		StringBuffer dataBuffer = new StringBuffer();
		StringBuffer timeBuffer = new StringBuffer();
		
		for(int i = 0;i<list.size();i++){
			Video st = list.get(i);
			dataBuffer.append(st.getCName());
			timeBuffer.append(st.getAvgTimes());
			if(i!=list.size()-1){
				dataBuffer.append(",");
				timeBuffer.append(",");
			}
			
			
		}
		
		
		
		md.addAttribute("data", dataBuffer.toString());
		md.addAttribute("times", timeBuffer.toString());
	
		
		return "/video/listView" ;
		
		
	}
	
	
}
