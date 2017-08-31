package com.zhiyou100.model;

import java.util.List;

public class UserVO {

	private User u;
	
	private List<User> list;

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "UserVO [u=" + u + ", list=" + list + "]";
	}
	
	
}
