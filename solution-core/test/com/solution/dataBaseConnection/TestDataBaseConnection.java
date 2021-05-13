package com.solution.dataBaseConnection;

import java.sql.ResultSet;
import java.sql.Statement;

import com.solution.databasehandler.DataBaseConnection;

public class TestDataBaseConnection {
	
	public static void main(String[] args) {
	
		DataBaseConnection dbc = new DataBaseConnection( "sol_schema", "solution", "soluti77");
		
		Statement stt = dbc.getStatement();
		
		String query = "SELECT id, first_name, last_name, passwrd FROM sol_users_tbl"; 
		
		try {
			ResultSet rs;
			rs = stt.executeQuery( query );
			
			while( rs.next() ) {
				System.out.println( rs.getString( "ID" ) );
			}
			
		} catch( Exception e ) {
			e.printStackTrace();
		}
		
		dbc.closeClonection();
	}
}