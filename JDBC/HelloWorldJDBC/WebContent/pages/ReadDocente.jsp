<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	
	<head>
		<meta charset="ISO-8859-1">
		<title>Read Docente</title>
	</head>

	<body>
	<table border="1">
	<tr><td>idDocente</td><td>nome</td><td>cognome</td></tr>
	<%
	try{
		
		// Verifico che il driver esista
		Class.forName("com.mysql.cj.jdbc.Driver");  
		
		// Stringa di connessione al database
		Connection con = DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/universitadb?serverTimezone=UTC","root","FrescaInsalata");  
	  
		// Per inviare SQL statements al database
		Statement stmt = con.createStatement();  
		
		// Per eseguire lo statement (query) ricevuto precedentemente
		ResultSet rs = stmt.executeQuery("select * from docente");
		
		while(rs.next())  
		out.println("<tr>"+"<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"</tr>"+"<br/>");  
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
	%>
	</table>
	<br/>
	<br/>
	Return to <a href="http://localhost:8080/HelloWorldJDBC/pages/Home.html">Index</a>.	
	</body>
</html>