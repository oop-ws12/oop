package prenns.ue1;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * @author Alexander Prennsberger
 */
public class MusikGruppe {

	private String name;
	private String ausrichtung;
	private List<Event> events;
	private List<Mitglied> members;

	public MusikGruppe(String name, String ausrichtung) {

		this.name = name;
		this.ausrichtung = ausrichtung;
		events = new ArrayList<Event>();
		members = new ArrayList<Mitglied>();

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAusrichtung() {
		return ausrichtung;
	}

	public void setAusrichtung(String ausrichtung) {
		this.ausrichtung = ausrichtung;
	}

	public void newEvent(Event ev) {
		events.add(ev);
	}

	public ArrayList<Event> getEvent(Date von, Date bis) {

		return getEvent(von, bis, Event.class);
	}

	public ArrayList<Event> getEvent(Date von, Date bis,
			Class<? extends Event> type) {

		ArrayList<Event> gesuchte = new ArrayList<Event>();

		for (Event e : events) {

			if (e.getAnfang().compareTo(bis) <= 0
					&& von.compareTo(e.getEnde()) <= 0) {

				if (e.getClass() == type) {

					gesuchte.add(e);
				}
			}
		}

		return gesuchte;
	}

	public void newMember(Mitglied member) {

		members.add(member);
	}
}
