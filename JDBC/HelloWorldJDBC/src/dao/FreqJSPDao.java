package dao;

import java.sql.*;

public class FreqJSPDao {
	
	Connection con;
	Statement stmt;
	
	public FreqJSPDao() {
		
		try{  
			
			// Verifico che il driver esista
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			// Stringa di connessione al database
			con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/universitadb?serverTimezone=UTC","root","FrescaInsalata");  
		  
			// Per inviare SQL statements al database
			stmt = con.createStatement();  
		
		}catch(Exception e){ System.out.println(e);} 	
	}
	

}
