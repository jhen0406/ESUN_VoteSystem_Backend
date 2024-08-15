package com.example.vote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "vote")

public class Vote {

	// GenerationType.IDENTITY: �N�� PK �Ʀr�Ѹ�Ʈw�Ӧ۰ʼW�[
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "intro")
	private String intro;

	public Vote() {
		super();
	}

	public Vote(int id, String name, String intro) {
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
