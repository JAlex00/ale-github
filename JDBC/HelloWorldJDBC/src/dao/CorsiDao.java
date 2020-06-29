package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.*;


public class CorsiDao {

	Connection con;
	Statement stmt;
	DateFormat df = new SimpleDateFormat("yy/MM/dd");
	Date dateobj = new Date();
	 
	public CorsiDao() {
		
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

	public void inserisci(String descrizione) {
			
		try{ 
			
			// Per eseguire lo statement (query) ricevuto precedentemente
			stmt.executeUpdate("INSERT INTO corsi (descrizione, dataCreazione) values ('"+descrizione+"', '"+df.format(dateobj)+"')");  
			con.close();  
		
		}catch(Exception e){ System.out.println(e);} 	
	}
	
	public void aggiorna(int id, String colonna, String nuovo) {
		
		try{ 
			
			stmt.executeUpdate("UPDATE corsi SET "+colonna+" = '"+nuovo+"' WHERE idCorsi = "+id);
			
			con.close(); 
			
		}catch(Exception e){ System.out.println(e);}
	}
		
	public void cancella(int id) {
		
		try {
			
			stmt.executeUpdate("DELETE FROM corsi WHERE idCorsi = "+id);  
			
			con.close();  
			
		}catch(Exception e){ System.out.println(e);}
	}
	
	public void stampaTutto() {
		
		try {
			
			ResultSet rs = stmt.executeQuery("select * from corsi");  
			
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getDate(3));  
			con.close();
			
		}catch(Exception e){ System.out.println(e);}
	}
	
}
