package com.example.vote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "response")
public class Response {

	@Column(name = "user_name")
	private String userName;

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "select_item")
	private String select;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(String userName, String userId, String select) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.select = select;
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

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

}
