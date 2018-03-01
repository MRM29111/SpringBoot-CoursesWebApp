package com.zavada.entity.enumeration;

public enum Role {

	ROLE_TEACHER("TEACHER"), ROLE_STUDENT("STUDENT");

	private String role;

	private Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

}
