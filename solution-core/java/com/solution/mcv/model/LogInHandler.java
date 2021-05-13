package com.solution.mcv.model;

import java.util.List;

import com.solution.mcv.dto.UserDTO;
import com.solution.mcv.dto.UserLogInDTO;

public class LogInHandler {
	
	private static LogInHandler instance;
	
	private List< String > messages;
	
	public LogInHandler getInstance() {
		if ( instance == null ) {
			instance = new LogInHandler();
		}
		
		return instance;
	}
	
//	public boolean logIn( UserDTO user, SytemPropertiesDTO systemProperties ) {
	/**
	 * <html> Return true is the user exists in the database and the pass is correct. </html>
	 * @param user
	 * @return
	 */
	public boolean logIn( UserLogInDTO user ) {
		
		boolean isUser = false;
		
		//Find user in database;
		UserModel userM = new UserModel();
		userM.getUser( user );
		
		//if exists check password;
		//return 
		
		return isUser;
	} 
}