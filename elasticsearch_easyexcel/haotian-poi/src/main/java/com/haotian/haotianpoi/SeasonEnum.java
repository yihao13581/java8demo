package com.haotian.haotianpoi;

public enum SeasonEnum {
	/**
	 *
	 */
	SPRING("1","春天"),
	SUMMER("2","夏天"),
	FALL("3","秋天"),
	WINTER("4","冬天");

	private String code;
	private String message;
	private SeasonEnum(String code,String message){
		this.code=code;
		this.message=message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
