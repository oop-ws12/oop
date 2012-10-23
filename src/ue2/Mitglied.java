package ue2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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

	public boolean addProbe(Probe b) {

		return probenBesucht.add(b);
	}

	/**
	 * Prueft, ob das Mitglied eine bestimme Anzahl an Proben, in dem
	 * angegebenen Zeitraum besucht hat
	 * 
	 * @param von
	 * @param bis
	 * @param anzahl
	 * @return true
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
