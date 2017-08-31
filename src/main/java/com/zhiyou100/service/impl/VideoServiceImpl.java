package com.zhiyou100.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.CourseMapper;
import com.zhiyou100.mapper.SpeakerMapper;
import com.zhiyou100.mapper.VideoMapper;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Video;
import com.zhiyou100.model.VideoExample;
import com.zhiyou100.model.VideoRemote;
import com.zhiyou100.service.VideoService;
import com.zhiyou100.util.Page;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoMapper vm;
	@Autowired
	SpeakerMapper sm;
	@Autowired
	CourseMapper cm;
	
	
	@Override
	public Page loadPage(VideoRemote vr) {
		
		/*System.out.println(vr);*/
		Page<Video> page = new Page<Video>();
		
		page.setTotal(vm.findVideoCount(vr));
	/*	System.out.println(vm.findVideoCount(vr));*/
		page.setSize(10);
		page.setPage(vr.getCurrentPage());
		vr.setCurrentPage((vr.getCurrentPage()-1)*10);
		page.setRows(vm.loadPage(vr));
		
		return page;
		
	}
	
	@Override
	public List<Speaker> findSpeaker() {
		
		return sm.selectByExample(null);
	}

	@Override
	public List<Course> findCourse() {
		
		return cm.selectByExample(null);
	}

	@Override
	public List<Video> findVideo() {
		
		return vm.selectByExample(null);
	}

	@Override
	public void deleteVideo(Integer id) {
		
		VideoExample ve = new VideoExample();
		
		ve.createCriteria().andIdEqualTo(id);
		
		vm.deleteByExample(ve);
	}

	@Override
	public void addVideo(Video vd) {
		
		vm.insertSelective(vd);
	}

	@Override
	public Video updateVideo(Integer id) {
		
		return vm.selectByPrimaryKey(id);
	}

	@Override
	public void updateVideoView(Video vd) {
		
		vm.updateByPrimaryKeySelective(vd);
	}

	@Override
	public List<Video> findVideoAndCourse() {
		
		return vm.selectVideoAndCourse();
	}

	
	
	
	
	@Override
	public void batchDelete(Integer[] checkid) {
		VideoExample ve = new VideoExample();
		ve.createCriteria().andIdIn(Arrays.asList(checkid));
		vm.deleteByExample(ve);
		
	}

	@Override
	public void deleteVideoById(Integer id) {
		vm.deleteByPrimaryKey(id);
		
	}

	@Override
	public Video getVideo(Integer videoId) {
		
		return vm.selectByPrimaryKey(videoId);
	}

	@Override
	public List<Video> fingVideosBySpeakerId(Integer speakerId) {
		VideoExample ve = new VideoExample();
		ve.createCriteria().andSpeakerIdEqualTo(speakerId);
		return vm.selectByExample(ve);

	}

	@Override
	public void addVideoId(Integer videoId) {
		Video vv = vm.selectByPrimaryKey(videoId);
		vv.setVideoPlayTimes(vv.getVideoPlayTimes()+1);
		vm.updateByPrimaryKeySelective(vv);
		
	}

}
