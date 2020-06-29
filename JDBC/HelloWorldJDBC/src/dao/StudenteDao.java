package dao;

import java.sql.*;

public class StudenteDao {
	
	Connection con;
	Statement stmt;
	
	public StudenteDao() {
		
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

	public void inserisci(String nome, String cognome) {
			
		try{ 
			
			// Per eseguire lo statement (query) ricevuto precedentemente
			stmt.executeUpdate("INSERT INTO studente (nome, cognome) values ('"+nome+"', '"+cognome+"')");  
			
			con.close();  
		
		}catch(Exception e){ System.out.println(e);} 	
	}
	
	public void aggiorna(int id, String colonna, String nuovo) {
		
		try{ 
			
			stmt.executeUpdate("UPDATE studente SET "+colonna+" = '"+nuovo+"' WHERE idStudente = "+id);
			
			con.close(); 
			
		}catch(Exception e){ System.out.println(e);}
	}
		
	public void cancella(int id) {
		
		try {
			
			stmt.executeUpdate("DELETE FROM studente WHERE idStudente = "+id);  
			
			con.close();  
			
		}catch(Exception e){ System.out.println(e);}
	}
	
	public void stampaTutto() {
		
		try {
			
			ResultSet rs = stmt.executeQuery("select * from studente");  
			
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();
			
		}catch(Exception e){ System.out.println(e);}
	}
	
	
}
