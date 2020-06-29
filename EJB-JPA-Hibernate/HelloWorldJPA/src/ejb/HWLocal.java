package ejb;

import javax.ejb.Local;
import model.Utente;

@Local
public interface HWLocal {

	public boolean inser(Utente ut);
	public boolean stampa1(int id);
	public boolean stampa2();
	public boolean del(int id);
}
	

