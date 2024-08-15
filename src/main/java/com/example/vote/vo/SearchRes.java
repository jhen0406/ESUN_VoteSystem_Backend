package com.example.vote.vo;

import java.util.List;

import com.example.vote.entity.Vote;

public class SearchRes extends BasicRes {

	private List<Vote> voteList;

	public SearchRes() {
		super();
	}

	public SearchRes(int statusCode, String message, List<Vote> voteList) {
		super(statusCode, message);
		this.voteList = voteList;
	}

	public List<Vote> getVoteList() {
		return voteList;
	}

	public void setVoteList(List<Vote> voteList) {
		this.voteList = voteList;
	}

}
