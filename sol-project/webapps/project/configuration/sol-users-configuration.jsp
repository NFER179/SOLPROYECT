<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.solution.databasehandler.DataBaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
			<input type="button" value="Back" >
			<input type="button" value="New" >
		</div>
		<div>
			<div>
				<table id="usertable" style="border: 1px solid;">
					<thead style="border: 2px;">
						<tr>
							<th>ID</th>
						</tr>
					</thead>
				</table>
			</div>
			<div>
				<form id="frm_user_details" >
					<label>Nombre: </label>
					<input id="npt_name" type="text" value="" >
					<br>
					<label>Apellido: </label>
					<input id="npt_last_name" type="text" value="" >
					<input id="sbmt_update_user_information" type="button" value="Actualizar">
				</form>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="../sol-core/jquery-3.5.1.js"></script>
	<script type="text/javascript">
		let frmUserDetails = $( '#frm_user_details' )
		let nptName = $( '#npt_name' )
		let nptLastName = $( '#npt_lst_name' )
		let user_data = <%
		 	DataBaseConnection dbc = new DataBaseConnection( "sol_schema", "solution", "soluti77" );
			String query = "SELECT id, first_name, last_name, passwrd FROM sol_users_tbl";
			String json_output = "'{\"user\" : [%s] }'";
			String user_data_struct = "{ \"Id\":\"%s\", \"FirstName\":\"%s\", \"LastName\":\"%s\" }";
			String json_data = "";
			HashMap< String, String[] > user_map = new HashMap< String, String[] >();
		
			Statement stt = dbc.getStatement();
		
			boolean first_line = true;
		
			try{
				ResultSet rs = stt.executeQuery( query );
				while( rs.next() ){
		
					if ( first_line == true ) {
						json_data += String.format( user_data_struct, rs.getString( "id" ), rs.getString( "first_name" ), rs.getString( "last_name" ) );
						first_line = false;
					} else {
						json_data += ", " + String.format( user_data_struct, rs.getString( "id" ), rs.getString( "first_name" ), rs.getString( "last_name" ) );	
					}								
				}					
			} catch( Exception e ) {
				out.write( e.getMessage() );
			} 
						
			out.write( String.format( json_output, json_data) );
			%>
		let json_user_data = JSON.parse( user_data )
		
		let userTable = $( "#usertable" )

		let row = $( '<tbody>' )
		
		$.each( json_user_data, function( key, object ){
			$.each( object, function( key02, object02 ){
				row.append( $( '<tr>' ).append( $( '<td>' ).append( object02.Id ) ) )
			} )
		} )
		
		userTable.append( row )
		
	</script>
	<script type="text/javascript" src="sol-users-configuration.js"></script>
</html>