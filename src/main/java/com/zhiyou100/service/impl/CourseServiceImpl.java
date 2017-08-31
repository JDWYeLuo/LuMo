package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.CourseMapper;
import com.zhiyou100.mapper.SubjectMapper;
import com.zhiyou100.mapper.VideoMapper;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.CourseExample;
import com.zhiyou100.model.CourseRemote;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;
import com.zhiyou100.model.VideoExample;
import com.zhiyou100.service.CourseService;
import com.zhiyou100.util.Page;


@Service
public class CourseServiceImpl implements CourseService {

	
	@Autowired
	CourseMapper cm;
	@Autowired
	SubjectMapper smp;
	@Autowired
	VideoMapper vm;
	
	@Override
	public Page listCourse(Integer currentPage) {
		Page<Course> page = new Page<Course>();
		
		int total = cm.listCounts();
		page.setTotal(total);
		
		page.setSize(10);
		
		
		page.setPage(currentPage);
		int pages = ((currentPage-1)*10);
		List<Course> row = cm.findCourseAll(pages);
		
		page.setRows(row);
		
		return page;
	}

	@Override
	public void addCourse(Course ce) {
		
		cm.insertSelective(ce);
	}

	@Override
	public List<Subject> findSubject() {
		
		return smp.selectByExample(null);
	}

	@Override
	public void deleteCourse(Integer id) {
		CourseExample cee = new CourseExample();
		cee.createCriteria().andIdEqualTo(id);
		cm.deleteByExample(cee);
	}

	@Override
	public Course updateCourse(Integer id) {
		
		return cm.selectByPrimaryKey(id);
	}

	@Override
	public void updateCourseView(Course ce) {
		
		cm.updateByPrimaryKeySelective(ce);
	}

	@Override
	public Subject findSubject(Integer subjectId) {
		
		return smp.selectByPrimaryKey(subjectId);
	}

	@Override
	public List<Course> findCourseId(Integer subjectId) {
		
		CourseExample ce = new CourseExample();
		ce.createCriteria().andSubjectIdEqualTo(subjectId);
		
		List<Course> courses = cm.selectByExample(ce);
		
		for (Course course : courses) {
			//获取course  id
			VideoExample ve = new VideoExample();
			ve.createCriteria().andCourseIdEqualTo(course.getId());
			
			List<Video> videos = vm.selectByExample(ve);
			course.setVideoList(videos);
			
		}
		
		return courses;

	}

	@Override
	public Course getCourse(Integer courseId) {
		
		return cm.selectByPrimaryKey(courseId);
	}

	
	
	
}
