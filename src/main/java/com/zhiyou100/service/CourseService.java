package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.CourseRemote;
import com.zhiyou100.model.Subject;
import com.zhiyou100.util.Page;

public interface CourseService {

	Page listCourse(Integer currentPage);

	void addCourse(Course ce);

	List<Subject> findSubject();

	void deleteCourse(Integer id);

	Course updateCourse(Integer id);

	void updateCourseView(Course ce);

	Subject findSubject(Integer subjectId);

	List<Course> findCourseId(Integer subjectId);

	Course getCourse(Integer courseId);

	

}
