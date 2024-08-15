package com.example.vote.vo;

public class SearchReq {

	private String name;

	private int id;

	public SearchReq() {
		super();
	}

	public SearchReq(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
