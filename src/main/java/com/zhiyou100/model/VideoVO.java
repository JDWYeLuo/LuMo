package com.zhiyou100.model;

import java.util.List;

public class VideoVO {
	
	private Video vd;
	
	private List<Video> list;

	public Video getVd() {
		return vd;
	}

	public void setVd(Video vd) {
		this.vd = vd;
	}

	public List<Video> getList() {
		return list;
	}

	public void setList(List<Video> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ViseoVO [vd=" + vd + ", list=" + list + "]";
	}
	
	
	
	
	
}
