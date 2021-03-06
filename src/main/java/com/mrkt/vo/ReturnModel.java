package com.mrkt.vo;

import java.io.Serializable;

import com.mrkt.constant.ExceptionStatus;

public class ReturnModel implements Serializable {

	private static final long serialVersionUID = 226291821671270583L;

	private Integer code;
	
	private String message;
		
	private Object content;
	
	public ReturnModel() {}
	
	public ReturnModel(Integer code, String message, Object content){
		this.code = code;
		this.message = message;
		this.content = content;
	}
	
	public ReturnModel(ExceptionStatus exceptionStatus, Object content){
		this.code = exceptionStatus.getCode();
		this.message = exceptionStatus.getMessage();
		this.content = content;
	}
	
	public static ReturnModel SUCCESS( Object content){
		return new ReturnModel(ExceptionStatus.SUCCESS, content);
	}
	
	public static ReturnModel SUCCESS(){
		return new ReturnModel(ExceptionStatus.SUCCESS, ExceptionStatus.DiY_OK_MESSAGE);
	}

/*	public static ReturnModel ERROR(BaseException e){
		return new ReturnModel(e.getCode(), e.getMessage(), e.getClass().getSimpleName()); 
	}*/
	
	public static ReturnModel ERROR(ExceptionStatus exceptionStatus){
		return new ReturnModel(exceptionStatus, ExceptionStatus.DiY_ERROR_MESSAGE); 
	}
	
	public static ReturnModel ERROR(ExceptionStatus exceptionStatus, String content){
		return new ReturnModel(exceptionStatus, content); 
	}
	
	public static ReturnModel ERROR(){
		return new ReturnModel(ExceptionStatus.ERROR, ExceptionStatus.DiY_ERROR_MESSAGE); 
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getContent() {
		return content;
	}
}
