<%@ page import="java.sql.*, javax.sql.DataSource, javax.naming.InitialContext, javax.naming.NamingException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
	<meta charset="ISO-8859-1">
	<title>Lista Movimenti</title>
	</head>

	<body>
	<h1>Movimenti:</h1>
	<table border="1">
	<tr><td>Ent/Usc</td><td>saldo</td><td>data</td></tr>
	<% 
	String idConto = request.getParameter("idConto");
	
	try{  
		
		DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
		
		try {
			
			Connection con = ds.getConnection();
			Statement stmt = con.createStatement();  
	
			ResultSet rs = stmt.executeQuery("SELECT entUsc, saldo, data FROM listamovimenti WHERE idConto='"+idConto+"'");
			
			while(rs.next()) 
			
				if(rs.getString(1).startsWith("+")==true){
					
					out.println("<tr>"+"<td>"+"<p style="+"color:Green;"+">"+rs.getString(1)+"</p>"+"</td>"+
					"<td>"+rs.getDouble(2)+"</td>"+"<td>"+rs.getDate(3)+"</td>"+"</tr>"+"<br/>");  
				}
			
				else{
					
					out.println("<tr>"+"<td>"+"<p style="+"color:Red;"+">"+rs.getString(1)+"</p>"+"</td>"+
					"<td>"+rs.getDouble(2)+"</td>"+"<td>"+rs.getDate(3)+"</td>"+"</tr>"+"<br/>");
				}
			
			con.close();
			
		}catch(Exception e){ System.out.println(e);} 
		
	}catch(NamingException e){System.out.println(e);}
	%>
	</table>
	<br/>
	saldo attuale:
	<% 
	try{  
		
		DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
		
		try {
			
			Connection con = ds.getConnection();
			Statement stmt = con.createStatement();  
	
			ResultSet rs = stmt.executeQuery("SELECT saldo, data FROM conto WHERE idConto='"+idConto+"'");
			
			while(rs.next())  
			out.println(rs.getInt(1)+" | data creazione: "+rs.getDate(2));  
			con.close();
			
		}catch(Exception e){ System.out.println(e);} 
		
	}catch(NamingException e){System.out.println(e);}
	%>
	<br/>
	<br/>
	<a href="http://localhost:8080/FinalProject/pagesCONTO/Insert.html">Torna all'indice</a>.
	</body>
</html>