package ejb;

import javax.ejb.Remote;
import model.Utente;

@Remote
public interface HWRemote {

	public boolean inser(Utente ut);
	public boolean stampa1(int id);
	public boolean stampa2();
	public boolean del(int id);
}
	

