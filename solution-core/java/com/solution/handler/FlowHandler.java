package com.solution.handler;

import java.util.Properties;

public class FlowHandler {

	private static FlowHandler instance;
	
	private FlowHandler( Properties prop ) {
		
	}
	
	public FlowHandler getInstance( Properties prop ) {
		if ( instance == null )
			instance = new FlowHandler( prop );
		
		return instance;
	}
	
	public String logIn() {
		return "";
	}
}