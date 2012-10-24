
public class Infrastruktur {

	private EventType type;
	private String adresse;
	private String beschreibung;

	public Infrastruktur(EventType type, String adresse, String beschreibung) {

		this.type = type;
		this.adresse = adresse;
		this.beschreibung = beschreibung;
	}

	public EventType getType() {
		return type;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getBeschreibung() {
		return beschreibung;
	}
	
}
