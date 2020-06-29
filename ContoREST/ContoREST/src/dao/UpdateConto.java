package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UpdateConto {

	Connection con;
	Statement stmt;
	DataSource ds;
	DateFormat df = new SimpleDateFormat("yy/MM/dd");
	Date dateobj = new Date();
	
	public UpdateConto() {
		
		try{  
	
			ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			
			try {
				
				con = ds.getConnection();
				stmt = con.createStatement();  
		
			}catch(Exception e){ System.out.println(e);} 
			
		}catch(NamingException e){System.out.println(e);}
	
	}
	
	public void newConto(int id) {
		
		try {
			
			stmt.executeUpdate("INSERT INTO conto (idConto,saldo, data) values ('"+id+"', '0', '"+df.format(dateobj)+"')");
			
		}catch(Exception e) {System.out.println(e);}
		
	}
	
	public void entrate(int id, double ent) {
		
		try{ 
			
			double x = 0;
			
			double y = 0;
			
			stmt.executeUpdate("INSERT INTO entrate (idConto, positivo) values ('"+id+"', '"+ent+"')");
			
			ResultSet rs = stmt.executeQuery("select saldo from conto where idConto = "+id);
			
			while(rs.next()) {
			
				x = rs.getDouble(1);
			}
			
			y = x+ent;
				  
			stmt.executeUpdate("UPDATE conto SET saldo = '"+y+"' WHERE idConto = "+id);
			
			stmt.executeUpdate("INSERT INTO listamovimenti (idConto, entUsc, saldo, data) values ('"+id+"', '+"+ent+"', '"+y+"', '"+df.format(dateobj)+"')");
	 	
		}catch(Exception e){ System.out.println(e);}
		
	}
	
	public void uscite(int id, double usc) {
		
		try{ 
			
			double a = 0;
			
			double b = 0;
			
			stmt.executeUpdate("INSERT INTO uscite (idConto, negativo) values ('"+id+"', '"+usc+"')");
			
			ResultSet rs = stmt.executeQuery("select saldo from conto where idConto = "+id);
			
			while(rs.next()) {
			
				a = rs.getDouble(1);
			}
			
			b = a-usc;
			
			stmt.executeUpdate("UPDATE conto SET saldo = '"+b+"' WHERE idConto = "+id);
			
			stmt.executeUpdate("INSERT INTO listamovimenti (idConto, entUsc, saldo, data) values ('"+id+"', '-"+usc+"', '"+b+"', '"+df.format(dateobj)+"')");
			
		}catch(Exception e){ System.out.println(e);}
		
	}
	
}
