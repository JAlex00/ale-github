package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrequenzeDao {

	Connection con;
	Statement stmt;
	DateFormat df = new SimpleDateFormat("yy/MM/dd");
	Date dateobj = new Date();
	 
	public FrequenzeDao() {
		
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

	public void inserisci(int idCorso, int idStudente) {
			
		try{ 
			
			// Per eseguire lo statement (query) ricevuto precedentemente
			stmt.executeUpdate("INSERT INTO frequenze (idCorso, idStudente, dataInizio) values ('"+idCorso+"', '"+ idStudente+"', '"+df.format(dateobj)+"')");  
			con.close();  
		
		}catch(Exception e){ System.out.println(e);} 	
	}
	
	public void aggiorna(int id, String colonna, String nuovo) {
		
		try{ 
			
			stmt.executeUpdate("UPDATE frequenze SET "+colonna+" = '"+nuovo+"' WHERE id = "+id);
			
			con.close(); 
			
		}catch(Exception e){ System.out.println(e);}
	}
		
	public void cancella(int id) {
		
		try {
			
			stmt.executeUpdate("DELETE FROM frequenze WHERE id = "+id);  
			
			con.close();  
			
		}catch(Exception e){ System.out.println(e);}
	}
	
	public void stampaTutto() {
		
		try {
			
			ResultSet rs = stmt.executeQuery("select * from frequenze");  
			
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getDate(4));  
			con.close();
			
		}catch(Exception e){ System.out.println(e);}
	
	}
	
}
