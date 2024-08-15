package com.example.vote.vo;

public class StatisticsRes extends BasicRes {

	private int voteId;

	private int count;

	public StatisticsRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticsRes(int statusCode, String message, int voteId, int count) {
		super(statusCode, message);
		this.voteId = voteId;
		this.count = count;
	}

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
