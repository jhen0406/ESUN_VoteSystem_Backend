package com.example.vote.vo;

import javax.validation.constraints.NotBlank;

public class CreateOrUpdateReq {

	private int id;

	@NotBlank(message = "Param quiz name error!!") // message = "" ，只能接固定的值
	private String name;

	private String intro;
	public CreateOrUpdateReq() {
		super();
	}

	public CreateOrUpdateReq(int id, @NotBlank(message = "Param quiz name error!!") String name, String intro) {
		super();
		this.id = id;
		this.name = name;
		this.intro = intro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
}
