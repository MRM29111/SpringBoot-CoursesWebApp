package com.zavada.entity.enumeration;

public enum Category {

	DEVELOPMENT("DEVELOPMENT"), MARKETING("MARKETING"), IT_SOWTWARE("IT&SOWTWARE"), DESIGN("DESIGN"), MUSIC(
			"MUSIC"), HEALTH_FITNESS("HEALTH&FITNESS");

	private String name;

	private Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
