package Entità;

import java.sql.Date;

import Gui.PanelAggiungiStudente;

public class Studente {
	
	private int id;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String genere;
	
	// Costruttori
	public Studente(int id, String nome, String cognome, String dataNascita, String genere) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.genere = genere;
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

	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
	

