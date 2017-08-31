package com.zhiyou100.model;

public class VideoRemote {
	private String videoKeyTitle;
	
	private String videoKeynoteSpeaker;
	
	private String videoKeyCourse;
	
	private Integer currentPage;

	private int speakerId = 0;
	
	private int courseId = 0;
	
	public String getVideoKeyTitle() {
		return videoKeyTitle;
	}

	public void setVideoKeyTitle(String videoKeyTitle) {
		this.videoKeyTitle = videoKeyTitle;
	}


	public String getVideoKeynoteSpeaker() {
		return videoKeynoteSpeaker;
	}

	public void setVideoKeynoteSpeaker(String videoKeynoteSpeaker) {
		this.videoKeynoteSpeaker = videoKeynoteSpeaker;
	}

	

	
	
	public String getVideoKeyCourse() {
		return videoKeyCourse;
	}

	public void setVideoKeyCourse(String videoKeyCourse) {
		this.videoKeyCourse = videoKeyCourse;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public int getSpeakerId() {
		return speakerId;
	}

	public void setSpeakerId(int speakerId) {
		this.speakerId = speakerId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "VideoRemote [videoKeyTitle=" + videoKeyTitle + ", videoKeynoteSpeaker=" + videoKeynoteSpeaker
				+ ", videoKeyCourse=" + videoKeyCourse + ", currentPage=" + currentPage + ", speakerId=" + speakerId
				+ ", courseId=" + courseId + "]";
	}
	
	
}
