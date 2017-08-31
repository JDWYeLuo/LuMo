package com.zhiyou100.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.CourseService;
import com.zhiyou100.service.FrontCourseVideoService;
import com.zhiyou100.service.SpeakerService;
import com.zhiyou100.service.VideoService;

@Controller
public class FrontCourseVideo {
	
	
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	@Autowired
	FrontCourseVideoService fcs;
	
	
	//主界面内课程
	@RequestMapping("/front/course/index.action")
	public String frontCourseList(Integer subjectId,Model md,HttpSession session){
		
		Subject subject = cs.findSubject(subjectId);
		md.addAttribute("subject", subject);
		
		List<Course> course = cs.findCourseId(subjectId);
		md.addAttribute("courses", course);
		md.addAttribute("subjectId", subjectId);
		/*System.out.println(course);
		System.out.println(subjectId);
		System.out.println(subject);*/
		return "front/course/index";
	}
	
	
	     //进入视频界面
		@RequestMapping("/front/video/index.action")
		public String videoIndex(Integer videoId,Integer subjectId,Model m){
			
			Subject subject = cs.findSubject(subjectId);
			m.addAttribute("subject", subject);
			m.addAttribute("videoId", videoId);
			return "/front/video/index";
		}

	
		//主讲人
		@RequestMapping("/front/video/videoData.action")
		public String videoData(Integer videoId,Integer subjectId,Model m){
		
			
			Subject subject = cs.findSubject(subjectId);
			m.addAttribute("subject", subject);
			
			
			Video video = vs.getVideo(videoId);
			m.addAttribute("video", video);
			Speaker speaker = ss.getSpeaker(video.getSpeakerId());
			m.addAttribute("speaker", speaker);
			Course course = cs.getCourse(video.getCourseId());
			m.addAttribute("course", course);
			List<Video> videos = vs.fingVideosBySpeakerId(video.getSpeakerId());
			m.addAttribute("videoList", videos);
			/*System.out.println(videos);*/
			
			return "/front/video/content";
			
		}
	
	
	    //播放量    /front/video/state.action
	
		@RequestMapping("/front/video/state.action")
		public String state(Integer videoId,Integer subjectId,Model m){
			
			vs.addVideoId(videoId);
			
			return "/front/video/content";
		}
	
	
	
	
	
	
	
}
