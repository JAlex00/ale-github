package dao;

import java.util.List;
import javax.persistence.*;
import model.Utente;

public class UtenteDao {

	private EntityManager em;

	public UtenteDao(EntityManager entityManager) {
		
		this.em = entityManager;		
	}
	
	public boolean insertUtente(Utente ut) throws Exception {
	
		em.persist(ut);

		return true;
	}
	
	public Utente selectById(int id) throws Exception{
		
		Utente res = em.find(Utente.class, id);
		
		return res;
	}

	public boolean removeUtente(int id) throws Exception{
		
		Utente ut = em.find(Utente.class, id);
		em.remove(ut);
		
		return true;
	}
	
	//tipo query con Hibernate (le 2 seguenti)
	public Utente selectHQLById(int id) throws Exception{
		
		Query q = em.createQuery("SELECT c FROM Utente c WHERE c.id = :cg");
		
		q.setParameter("cg", id);
		
		
		Utente u = (Utente) q.getSingleResult();
		
		return u;
	}
	
	public List<Utente> selectHQL() throws Exception{
		
		//Query q = em.createQuery("SELECT c FROM Utente c WHERE c.cognome = :cg");
		Query q = em.createQuery("FROM Utente");
		
		//q.setParameter("cg", str);	
		
		@SuppressWarnings("unchecked")
		List<Utente> res = q.getResultList();
		
		return res;
	}
	
}
