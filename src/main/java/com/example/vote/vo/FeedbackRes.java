package com.example.vote.vo;

import java.util.List;

import com.example.vote.entity.Response;
import com.example.vote.entity.Vote;

public class FeedbackRes extends BasicRes {

	private List<Response> feedbackList;

	public FeedbackRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackRes(int statusCode, String message,List<Response> feedbackList) {
		super(statusCode, message);
		this.feedbackList = feedbackList;
	}

	public List<Response> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<Response> feedbackList) {
		this.feedbackList = feedbackList;
	}

	

}
