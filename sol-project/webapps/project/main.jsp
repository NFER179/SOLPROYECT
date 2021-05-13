<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>



<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>		
	</head>
	<body>
		<h1>Hola <% out.write( (String)session.getAttribute( "solution.user" ) ); %></h1>
		<ul>
			<li>
				<span>Configuration</span>
				<ul>
					<li>
						<span>Usuarios</span><input type="button" id="user_configuration" value="ABM user" />
					</li>
				</ul>
			</li>
		</ul>
	</body>
	<script type="text/javascript" src="sol-core/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="main.js"></script>
</html>