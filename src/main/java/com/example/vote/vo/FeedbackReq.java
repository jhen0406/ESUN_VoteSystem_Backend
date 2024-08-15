package com.example.vote.vo;

public class FeedbackReq {

	private String userName;

	public FeedbackReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackReq(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
