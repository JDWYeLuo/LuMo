package com.zhiyou100.model;

import java.util.List;

public class CourseVO {
	private Course course;
	private List<Video> list;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Video> getList() {
		return list;
	}
	public void setList(List<Video> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "CourseVO [course=" + course + ", list=" + list + "]";
	}
	
	
	
}
