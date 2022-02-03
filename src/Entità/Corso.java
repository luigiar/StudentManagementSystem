package Entità;

import java.util.ArrayList;

public class Corso {

	private int codiceCorso;
	private String nome;
	private String descrizione;
	private  int maxPartecipanti;
	private ArrayList<Lezione> numeroLezioni = new ArrayList<>(20);
	private String areeTematiche;
	private int presenzeObbligatorie;

	// Costruttori
	public Corso(int codiceCorso, String nome, String descrizione, ArrayList<Lezione> numeroLezioni,
			int maxPartecipanti, String areeTematiche, int presenzeObbligatorie) {
		this.codiceCorso = codiceCorso;
		this.nome = nome;
		this.descrizione = descrizione;
		this.numeroLezioni = numeroLezioni;
		this.maxPartecipanti = maxPartecipanti;
		this.areeTematiche = areeTematiche;
		this.presenzeObbligatorie = presenzeObbligatorie;
	}

	public Corso() {

	}

	// Getter e setter
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getCodiceCorso() {
		return codiceCorso;
	}

	public void setCodiceCorso(int codiceCorso) {
		this.codiceCorso = codiceCorso;
	}

	public int getMaxPartecipanti() {
		return maxPartecipanti;
	}

	public void setMaxPartecipanti(int maxPartecipanti) {
		this.maxPartecipanti = maxPartecipanti;
	}

	public ArrayList<Lezione> getNumeroLezioni() {
		return numeroLezioni;
	}

	public void setNumeroLezioni(ArrayList<Lezione> numeroLezioni) {
		this.numeroLezioni = numeroLezioni;
	}

	public String getAreeTematiche() {
		return areeTematiche;
	}

	public void setAreeTematiche(String areeTematiche) {
		this.areeTematiche = areeTematiche;
	}

	public int getPresenzeObbligatorie() {
		return presenzeObbligatorie;
	}

	public void setPresenzeObbligatorie(int presenzeObbligatorie) {
		this.presenzeObbligatorie = presenzeObbligatorie;
	}

}
