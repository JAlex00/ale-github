package ejb;

import javax.persistence.*;
import ejb.HWLocal;
import ejb.HWRemote;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import dao.UtenteDao;
import model.Utente;
import java.util.List;

/**
 * Session Bean implementation class HelloStateLess
 */
@Stateless
@LocalBean
public class HelloWorldEJB implements HWRemote, HWLocal {

	@PersistenceContext(unitName="Hib4PU")
	private EntityManager em;
	
	/**
     * Default constructor. 
     */
	public HelloWorldEJB() {
	        // TODO Auto-generated constructor stub
	    }
	
	public boolean inser(Utente ut) {
		
		UtenteDao ud = new UtenteDao(em);
		
		try {
			
			ud.insertUtente(ut);
			
		}catch(Exception e) {e.printStackTrace();}
		
		return true;
	}
	
	public boolean del(int id) {
		
		UtenteDao ud3 = new UtenteDao(em);
		
		try {
			
			ud3.removeUtente(id);
			
		}catch(Exception e) {e.printStackTrace();}
		
		return true;
	}
	
	public boolean stampa1(int id) {
		
		UtenteDao ud1 = new UtenteDao(em);
		
		try {
			
			Utente ut1 = ud1.selectHQLById(id);
			System.out.println(ut1.getNome()+" "+ut1.getCognome()+" "+ut1.getEta());
			
		}catch(Exception e) {e.printStackTrace();}
		
		return true;
	}
	
	public boolean stampa2() {
		
		UtenteDao ud2 = new UtenteDao(em);
		
		try {
			
			List<Utente> res = ud2.selectHQL();
			
			for(int x=0; x<res.size(); x++) {
				
				Utente ut2 = res.get(x);
				System.out.println(ut2.getNome()+" "+ut2.getCognome()+" "+ut2.getEta());
				}
			
		}catch(Exception e) {e.printStackTrace();}
		
		return true;
	}
		
}
