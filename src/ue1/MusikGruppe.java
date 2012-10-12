package ue1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Stellt eine Musikgruppe dar.
 */
public class MusikGruppe {
	private String name;
	private String ausrichtung;
	
	private List<Event> events;
	private DeletionList<Mitglied> mitglieder;
	private DeletionList<Lied> repertoire;
	
	public MusikGruppe(String name, String ausrichtung) {
		this.name = name;
		this.ausrichtung = ausrichtung;
		
		this.events = new ArrayList<Event>();
		this.mitglieder = new DeletionList<Mitglied>();
		this.repertoire = new DeletionList<Lied>();
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

	public DeletionList<Mitglied> getMitglieder() {
		return mitglieder;
	}

	public DeletionList<Lied> getRepertoire() {
		return repertoire;
	}

	public void addEvent(Event event) {
		events.add(event);
	}
	
	/**
	 * Listet Events eines bestimmten Typs.
	 * 
	 * @param begin
	 * @param end
	 * @param type
	 * @return
	 */
	public Collection<Event> listEvents(Date begin, Date end, Class<? extends Event> type) {
		List<Event> filtered = new ArrayList<Event>();
		
		for(Event e : events) {
			boolean inRange = begin.compareTo(e.getEnde()) <= 0 && e.getBeginn().compareTo(end) <= 0;
			if(type.isInstance(e) && inRange) {
				filtered.add(e);
			}
		}
		
		return filtered;
	}
	
	/**
	 * Listet alle Events.
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public Collection<Event> listEvents(Date begin, Date end) {
		return listEvents(begin, end, Event.class);
	}
	
	/**
	 * Berechnet die Gesamtkosten/Gewinn des gegebenen Zeitraumes.
	 * 
	 * @param begin
	 * @param end
	 * @return Gesamtkosten/Gewinn
	 */
	public double summe(Date begin, Date end) {
		return summe(begin, end, Event.class);
	}
	
	/**
	 * Berechnet die Gesamtkosten/Gewinn des gegebenen Zeitraumes für eine bestimmte Art von Event.
	 * 
	 * @param begin
	 * @param end
	 * @return Gesamtkosten/Gewinn
	 */
	public double summe(Date begin, Date end, Class<? extends Event> type) {
		double summe = 0;
		
		for(Event e : events) {
			boolean inRange = begin.compareTo(e.getEnde()) <= 0 && e.getBeginn().compareTo(end) <= 0;

			if(type.isInstance(e) && inRange) {
				summe += e.abrechnung();
			}
		}
		
		return summe;
	}
}
