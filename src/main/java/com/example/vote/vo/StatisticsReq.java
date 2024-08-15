package com.example.vote.vo;

public class StatisticsReq {

	private int voteId;
	
	private String voteName;

	public StatisticsReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticsReq(int voteId, String voteName) {
		super();
		this.voteId = voteId;
		this.voteName = voteName;
	}

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}
	
	
}
