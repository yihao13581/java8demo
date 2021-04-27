package com.cmos.isccmp.util.emums;

/**
 * 返沪客户端信息枚举
 */
public enum ReturnInfoEnums {

	PROCESS_SUCCESS("0000","操作成功"),
	PROCESS_FAILED("2999","操作失败");


	private String code;
	private String message;
	private String message1;
	private String message2;
	private String message3;
	private ReturnInfoEnums(String code,String message){
		this.code=code;
		this.message=message;
	}
	private ReturnInfoEnums(String code,String message1,String message2){
		this.code=code;
		this.message1=message1;
		this.message2=message2;
	}
	private ReturnInfoEnums(String code,String message1,String message2,String message3) {
		this.code = code;
		this.message1 = message1;
		this.message2 = message2;
		this.message3 = message3;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage1() {
		return message1;
	}

	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public String getMessage3() {
		return message3;
	}

	public void setMessage3(String message3) {
		this.message3 = message3;
	}
}
