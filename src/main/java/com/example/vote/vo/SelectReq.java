package com.example.vote.vo;

import java.util.List;

public class SelectReq {

	private String userName;

	private String userId;

	private String voteIds;

//	private List<Integer> idList;

	public SelectReq() {
		super();
	}

	

	public SelectReq(String userName, String userId, String voteIds) {
	super();
	this.userName = userName;
	this.userId = userId;
	this.voteIds = voteIds;
}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVoteIds() {
		return voteIds;
	}

	public void setVoteIds(String voteIds) {
		this.voteIds = voteIds;
	}

//	public List<Integer> getIdList() {
//		return idList;
//	}
//
//	public void setIdList(List<Integer> idList) {
//		this.idList = idList;
//	}

}
