package com.solution.mcv.dto;

public class UserDTO {
	
	private UserLogInDTO userLogIn;
	private String name;
	private String role_name;
	
	public UserDTO() {
		
	}
	
	public String getId() {
		return this.userLogIn.getId();
	}
	
}