package com.example.vote.vo;

import java.util.List;

import com.example.vote.entity.Vote;

public class Feedback {

	private String userName;
	
	private List<Vote> voteList;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(String userName, List<Vote> voteList) {
		super();
		this.userName = userName;
		this.voteList = voteList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Vote> getVoteList() {
		return voteList;
	}

	public void setVoteList(List<Vote> voteList) {
		this.voteList = voteList;
	}
	
	
}
