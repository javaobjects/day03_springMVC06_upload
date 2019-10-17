package com.tencent.exception;

public class CustomerException extends RuntimeException {

	//保存异常错误信息
	private String message;
	
	//通过构造函数给message赋予异常信息原因
	public CustomerException(String message) {
		this.message = message;
	}
	
	//通过get方法获取异常信息原因
	public String getMessage() {
		return message;
	}
}
