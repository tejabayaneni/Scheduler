package com.assignment.util;

public enum Status {

	CREATED("0"), INPROGRESS("1"), DELIVERED("2"), CANCELLED("3");

	private final String levelCode;

	private Status(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getLevelCode() {
        return this.levelCode;
    }
	

}
