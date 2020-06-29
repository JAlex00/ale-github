package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Utente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;
	
	private String cognome;

	private int eta;
	
	public Utente() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
