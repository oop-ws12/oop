package ue2;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * Stellt eine Musikgruppe dar.
 */
public class MusikGruppe {
	private String name;
	private String ausrichtung;

	private EventList events;
	private DeletionList<Mitglied> mitglieder;
	private DeletionList<Lied> repertoire;
	private Finanzverwaltung finanzen;

	public MusikGruppe(String name, String ausrichtung) {
		this.name = name;
		this.ausrichtung = ausrichtung;

		this.events = new EventList();
		this.mitglieder = new DeletionList<Mitglied>();
		this.repertoire = new DeletionList<Lied>();
		this.finanzen = new Finanzverwaltung();
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

	public boolean addEvent(Event ev) {
		
		return events.add(ev) && finanzen.add(ev);

	}

	public Collection<Event> getEvents(Date von, Date bis) {
		return events.list(von, bis);
	}

	public Collection<Event> getEvents(Date von, Date bis,
			Class<? extends Event> type) {
		return events.list(von, bis, type);
	}

	public Entry<Event> getEventEntry(Event event) {
		return events.find(event);
	}

	public boolean addMember(Mitglied member) {
		return addMember(member, new Date());
	}
	
	public boolean addMember(Mitglied member, Date time) {
		if(mitglieder.add(member, time)) {
			events.addObserver(member);
			return true;
		}
		
		return false;
	}

	public boolean removeMember(Mitglied member, Date time) {
		if(mitglieder.remove(member, time)) {
			events.removeObserver(member);
			return true;
		}
		
		return false;
	}

	public boolean addSong(Lied lied, Date time) {
		return repertoire.add(lied, time);
	}

	public boolean removeSong(Lied lied, Date time) {
		return repertoire.remove(lied, time);
	}

	public Collection<Mitglied> getMembers() {
		return mitglieder;
	}

	public Collection<Entry<Mitglied>> getMembers(Date time) {
		return mitglieder.list(time);
	}

	public Collection<Lied> getSongs() {
		return repertoire;
	}

	public Collection<Entry<Lied>> getSongs(Date time) {
		return repertoire.list(time);
	}
	
	public boolean addFinanz(AllgemeinFinanzen f) {
		return finanzen.add(f);
	}
	
	public BigDecimal getBilanz(Date von, Date bis) {
		return finanzen.summe(von, bis);
	}
	
	public BigDecimal getEventBilanz(Date von, Date bis, Class<? extends Event> type) {
		return finanzen.summe(von, bis, type);
	}
	
	public BigDecimal getSonstigeBilanz(Date von, Date bis, String art) {
		return finanzen.summe(von, bis, art);
	}
	
}
