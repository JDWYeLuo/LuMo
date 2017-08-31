package com.zhiyou100.model;

public class CourseRemote {
	
	private int subjectId;

	private Integer currentPage;

	
	
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "CourseRemote [subjectId=" + subjectId + ", currentPage=" + currentPage + "]";
	}
	
	
}
