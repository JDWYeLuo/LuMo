package com.zhiyou100.model;

public class SpeakerRemote {

	private String speakerKeyName;
	
	private String speakerKeyJob;
	
	private Integer currentPage;

	public String getSpeakerKeyName() {
		return speakerKeyName;
	}

	public void setSpeakerKeyName(String speakerKeyName) {
		this.speakerKeyName = speakerKeyName;
	}

	public String getSpeakerKeyJob() {
		return speakerKeyJob;
	}

	public void setSpeakerKeyJob(String speakerKeyJob) {
		this.speakerKeyJob = speakerKeyJob;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "SpeakerRemote [speakerKeyName=" + speakerKeyName + ", speakerKeyJob=" + speakerKeyJob + ", currentPage="
				+ currentPage + "]";
	}
	
	
	
	
	
	
	
}
