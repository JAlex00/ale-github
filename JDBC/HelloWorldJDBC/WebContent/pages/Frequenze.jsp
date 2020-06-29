<%@ page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
	
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>

	<body>
		
		Operazioni CRUD per Frequenze
		<form action="http://localhost:8080/HelloWorldJDBC/FrequenzeSrv">	
			
			<fieldset>
			Operazione:
			<input readonly="readonly" name="operazione" value="inserisci"></input>
			idCorso:
			<select name="idCorso" >
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
				ResultSet rs = stmt.executeQuery("select * from corsi");
				
				while(rs.next())  
				out.print("<option value="+rs.getInt(1)+">"+rs.getInt(1)+"</option>");  
				con.close();
				
			}catch(Exception e){ System.out.println(e);}
			%>
			</select>
			idStudente:
			<select name="idStudente" >
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
				ResultSet rs = stmt.executeQuery("select * from studente");
				
				while(rs.next())  
				out.print("<option value="+rs.getInt(1)+">"+rs.getInt(1)+"</option>");  
				con.close();
				
			}catch(Exception e){ System.out.println(e);}
			%>
			</select>
			<input type="submit" value="invia"></input>
			<br />
			</fieldset>>
			
		</form>
			
		<form action="http://localhost:8080/HelloWorldJDBC/FrequenzeSrv">
			
			<fieldset>
			Operazione:
			<input readonly="readonly" name="operazione" value="cancella"></input>
			Id:
			<input type="text" name="id"></input>
			<input type="submit" value="invia"></input>
			<br />
			</fieldset>>
			
		</form>
			
		<form action="http://localhost:8080/HelloWorldJDBC/FrequenzeSrv">
			
			<fieldset>
			dataInizio:
			<input readonly="readonly" name="operazione" value="aggiorna"></input>
			Id:
			<input type="text" name="id"></input>
			Colonna:
			<input readonly="readonly" name="colonna" value="dataInizio"></input>
			Nuovo valore:
			<input type="text" name="nuovo"></input>
			<input type="submit" value="invia"></input>
			</fieldset>>
		
		</form>
		
		<form action="http://localhost:8080/HelloWorldJDBC/FrequenzeSrv">
			
			<fieldset>
			idCorso:
			<input readonly="readonly" name="operazione" value="aggiorna"></input>
			Id:
			<input type="text" name="id"></input>
			Colonna:
			<input readonly="readonly" name="colonna" value="idCorso"></input>
			Nuovo valore:
			<select name="idCorso" >
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
				ResultSet rs = stmt.executeQuery("select * from corsi");
				
				while(rs.next())  
				out.print("<option value="+rs.getInt(1)+">"+rs.getInt(1)+"</option>");  
				con.close();
				
			}catch(Exception e){ System.out.println(e);}
			%>
			</select>
			</fieldset>>
		
		</form>
		
		<form action="http://localhost:8080/HelloWorldJDBC/FrequenzeSrv">
			
			<fieldset>
			idStudente:
			<input readonly="readonly" name="operazione" value="aggiorna"></input>
			Id:
			<input type="text" name="id"></input>
			Colonna:
			<input readonly="readonly" name="colonna" value="idStudente"></input>
			Nuovo valore:
			<select name="idStudente" >
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
				ResultSet rs = stmt.executeQuery("select * from studente");
				
				while(rs.next())  
				out.print("<option value="+rs.getInt(1)+">"+rs.getInt(1)+"</option>");  
				con.close();
				
			}catch(Exception e){ System.out.println(e);}
			%>
			</select>
			</fieldset>>
		
		</form>
		
		<form action="http://localhost:8080/HelloWorldJDBC/FrequenzeSrv">
			
			<fieldset>
			Operazione:
			<input readonly="readonly" name="operazione" value="stampaTutto"></input>
			<input type="submit" value="invia"></input>
			</fieldset>
		
		</form>
		
	</body>

</html>