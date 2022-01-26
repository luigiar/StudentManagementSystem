package Entità;

import java.sql.Date;

public class Studente {
	
	private String id;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String genere;
	
	// Costruttori
	public Studente(String id, String nome, String cognome, String dataNascita, String genere) {
		id = this.id;
		nome = this.nome;
		cognome = this.cognome;
		dataNascita = this.dataNascita;
		genere = this.genere;
	}
	
	public Studente(String nome, String cognome, String dataNascita, String genere) {
		nome = this.nome;
		cognome = this.cognome;
		dataNascita = this.dataNascita;
		genere = this.genere;
	}
	
	public Studente() {
		super();
	}
	
	
	//Getter e Setter
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
	

