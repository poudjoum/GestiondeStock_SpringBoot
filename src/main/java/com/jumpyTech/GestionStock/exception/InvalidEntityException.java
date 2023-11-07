package com.jumpyTech.GestionStock.exception;

import java.util.List;

import lombok.Getter;




public class InvalidEntityException extends RuntimeException {
	@Getter
	private ErrorCode errorCode;
	@Getter
	private List<String>errors;


	public InvalidEntityException(String message) {
		super(message);
	}
	public InvalidEntityException(String message,Throwable cause) {
		super(message,cause);
	}
	public InvalidEntityException(String message, Throwable cause,ErrorCode errorCode) {
		super(message,cause);
		this.errorCode=errorCode;
	}
	public InvalidEntityException(String message,ErrorCode errorCode) {
		super(message);
		this.errorCode=errorCode;
	}
	public InvalidEntityException(String message,ErrorCode errorCode,List<String>errors) {
		super(message);
		this.errorCode=errorCode;
		this.errors=errors;
	}



}
