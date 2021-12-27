package Entità;
import java.util.ArrayList;

public class Corso {

	private String nome;
	private String descrizione; 
	private ArrayList<Studente> partecipanti = new ArrayList<>(100);
	private String CodiceCorso;
	private ArrayList<Lezione> numeroLezioni = new ArrayList<>(20);
	private ArrayList<AreeTematiche> tipo = new ArrayList<>();
	
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
	public String getCodiceCorso() {
		return CodiceCorso;
	}
	public void setCodiceCorso(String codiceCorso) {
		CodiceCorso = codiceCorso;
	}
	
	
}
