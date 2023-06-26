package com.athz.controller;

public class Respuesta {
	public static final String REDIRECT =  "redirect";
	public static final String DISPATCH = "dispatch";
	private String type;
	private String action;
	
	public Respuesta (String type, String action) {
		this.type = type;
		this.action = action;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	
	public String getType() {
		return type;
	}

	
	
}
