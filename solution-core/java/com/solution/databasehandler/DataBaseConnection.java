package com.solution.databasehandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBaseConnection {
	
	private static String pathConnection = "jdbc:mysql://localhost:3306/%s?serverTimezone=UTC";
	
	private String _dataBase;
	private String _user;
	private String _pass;
	// private static DataBaseConnection instancia = null;
	private Connection _con = null;
	private Statement _stt = null;
	
	public DataBaseConnection( String dataBase, String user, String pass ) {
		this._dataBase = dataBase;
		this._user = user;
		this._pass = pass;
	}
	
	public Statement getStatement() {
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" ).newInstance();
			
			this._con = DriverManager.getConnection( String.format(pathConnection, this._dataBase), this._user, this._pass );
			this._stt = this._con.createStatement();
		} catch( Exception e ) {
			e.printStackTrace();
		}
		
		return this._stt;
	}
	
	public void closeClonection() {
		if( this._con != null ) {
			this._con = null;
		}
		if( this._stt != null ) {
			this._stt = null;
		}
	}
}