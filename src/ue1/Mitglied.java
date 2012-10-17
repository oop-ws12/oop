package ue1;

public class Mitglied {
	private String name;
	private String telefon;
	private String instrument;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public Mitglied(String name, String telefon, String instrument) {
		this.name = name;
		this.telefon = telefon;
		this.instrument = instrument;
	}
}
