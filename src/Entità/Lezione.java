package Entità;

public class Lezione {

	
	private String descrizione;
	private String dataInizio;
	private String oraInizio;
	private int codiceLezione;
	private String titolo;
	private boolean presenza;
	private String durata;
	
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	public String getOraInizio() {
		return oraInizio;
	}
	public void setOraInizio(String oraInizio) {
		this.oraInizio = oraInizio;
	}
	public int getCodiceLezione() {
		return codiceLezione;
	}
	public void setCodiceLezione(int codiceLezione) {
		this.codiceLezione = codiceLezione;
	}
	public boolean isPresenza() {
		return presenza;
	}
	public void setPresenza(boolean presenza) {
		this.presenza = presenza;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String durata) {
		this.durata = durata;
	}
}
