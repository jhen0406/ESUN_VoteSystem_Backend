package com.example.vote.contants;

public enum ResMsg {

	SUCCESS(200, "Success!!"),//
	ITEM_EXISTS(400,"Item Exists"),//
	UPDATE_ID_NOT_FOUND(400,"Update Id Not Found"),//
	PARAM_USERNAME_IS_REQUIRED(400,"Param UserName Is Required"),//
	PARAM_USERID_IS_REQUIRED(400,"Param UserId Is Required"),//
	DUPLICATED_FILL_IN(400,"Duplicated Fill in"),//
	JSON_PROCESSING_EXCEPTION(400,"Json processing exception!!"),//
	ANSWER_IS_REQUIRED(400,"Answer is required!!"),//
	OPTION_IS_NOT_MATCH(400,"Option Is Not Match");

	private int code;

	private String message;

	private ResMsg(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
