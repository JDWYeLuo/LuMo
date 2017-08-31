package com.zhiyou100.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.SpeakerRemote;
import com.zhiyou100.service.SpeakerService;
import com.zhiyou100.util.Page;

@Controller
@RequestMapping("/admin")
public class SpeakerController {
	
	@Autowired
	SpeakerService ss;
	
	
	@RequestMapping("/speaker/listSpeaker.action")
	public String speakerList(@RequestParam(defaultValue="")String speakerKeyName,
			@RequestParam(defaultValue="")String speakerKeyJob, HttpServletRequest req,
			@RequestParam(value="page" ,required=false,defaultValue="1")Integer currentPage,Model md){
		
		md.addAttribute(speakerKeyName);
		md.addAttribute(speakerKeyJob);
		
	
		SpeakerRemote sr = new SpeakerRemote();
		sr.setSpeakerKeyName(speakerKeyName);
		sr.setSpeakerKeyJob(speakerKeyJob);
		sr.setCurrentPage(currentPage);
		
		Page  page = ss.listPage(sr);
		
		/*System.out.println("page:"+page);*/
		req.setAttribute("page", page);
		
		
		return "/speaker/SpeakerList";
	}
	
	@RequestMapping(value="/speaker/addSpeaker.action",method=RequestMethod.GET)
	public String speakerAdd(){
		
		return "/speaker/SpeakerAdd";
	}
	
	@RequestMapping(value="/speaker/addSpeaker02.action",method=RequestMethod.POST)
	public String speakerAdd02(Speaker sk){
		
		ss.addSpeaker(sk);
		
		return "redirect:/admin/speaker/listSpeaker.action";
	}
	
	@RequestMapping("/speaker/deleteSpeaker.action")
	public String speakerDelete(Integer id){
		
		ss.deleteSpeaker(id);
		
		return "redirect:/admin/speaker/listSpeaker.action";
	}
	
	@RequestMapping(value="/speaker/updateSpeaker.action",method=RequestMethod.GET)
	public String speakerUpdate(Integer id,HttpServletRequest req){
		
		/*Video vd = vs.updateVideo(id);
		System.out.println("vd:"+vd);
		req.setAttribute("video", vd);
		 * 
		 * 
		 * 
		 * */
		Speaker sk = ss.updateSpeaker(id);
		System.out.println("sk:"+sk);
		req.setAttribute("speaker", sk);
		return "/speaker/SpeakerUpdate";
	}
	@RequestMapping(value="/speaker/updateSpeaker02.action",method=RequestMethod.POST)
	public String speakerUpdate02(Speaker sk){
		
		ss.updateSpeakerView(sk);
		
		return "redirect:/admin/speaker/listSpeaker.action";
	}
	
	
	
	
}
