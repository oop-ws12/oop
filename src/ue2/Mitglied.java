
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Stellt ein Mitglied dar, welches ein Ersatzmitglied sein kann oder 
 * gesperrt sein kann
 * 
 */

public class Mitglied extends Model<Mitglied> implements
		Observer<ChangedEvent<Event>> {

	private String name;
	private String telefon;
	private String instrument;
	private EventList probenBesucht;
	private boolean gesperrt;
	private boolean ersatz;

	public boolean istErsatz() {
		return ersatz;
	}

	public void setErsatz(boolean wert) {
		this.ersatz = wert;
	}

	public String getName() {
		return name;
	}

	/**
	 * Setzt den Namen des Mitglieds
	 * 
	 * @param name != null
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getTelefon() {
		return telefon;
	}

	/**
	 * Setzt die Telefonnummer des Mitglieds
	 * 
	 * @param telefon != null
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	
	public boolean istGesperrt() {
		return gesperrt;
	}
	
	public void setGesperrt(boolean wert) {
		gesperrt = wert;
	}


	public Mitglied(String name, String telefon, String instrument) {
		this.name = name;
		this.telefon = telefon;
		this.instrument = instrument;
		this.probenBesucht = new EventList();
	}

	/**
	 * Fuegt eine neue Probe hinzu
	 * 
	 * @param b != null Probe
	 * @return true, falls nach Aufruf der Methode die Liste geaendert wurde, false sonst
	 */
	public boolean addProbe(Probe b) {

		return probenBesucht.add(b);
	}

	/**
	 * Prueft, ob das Mitglied eine bestimme Anzahl an Proben, in dem
	 * angegebenen Zeitraum besucht hat
	 * 
	 * @param von != null
	 * @param bis != null && bis > von
	 * @param anzahl != null
	 * @return true falls uebergebene Anzahl an Proben im uebergebenem Zeitraum besucht, false sonst
	 */
	public boolean hatProbenBesucht(Date von, Date bis, int anzahl) {

		Collection<Event> filterd = new ArrayList<Event>();

		filterd = probenBesucht.list(von, bis);

		if (filterd.size() >= anzahl)
			return true;

		else
			return false;
	}

	@Override
	public String toString() {
		return "Mitglied [name=" + name + ", instrument=" + instrument + "]";
	}

	@Override
	public Mitglied copy() {
		return new Mitglied(name, telefon, instrument);
	}

	@Override
	public void before(ChangedEvent<Event> event) {
	}

	@Override
	public void fired(ChangedEvent<Event> event) {
		// Event wurde geandert
	}
}
