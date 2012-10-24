
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

	/**
	 * Initialisiert die MusikGruppe.
	 * 
	 * @param name != null
	 * @param ausrichtung != null
	 */
	public MusikGruppe(String name, String ausrichtung) {
		this.name = name;
		this.ausrichtung = ausrichtung;

		this.events = new EventList();
		this.mitglieder = new DeletionList<Mitglied>();
		this.repertoire = new DeletionList<Lied>();
		this.finanzen = new Finanzverwaltung();
	}

	/**
	 * Liefert den Namen der MusikGruppe.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setzt den Namen der Musikgruppe.
	 * @param name != null
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Liefert die Ausrichtung der Musikgruppe.
	 * @return
	 */
	public String getAusrichtung() {
		return ausrichtung;
	}

	/**
	 * Setzt die Ausrichtung der MusikGruppe.
	 * @param ausrichtung != null
	 */
	public void setAusrichtung(String ausrichtung) {
		this.ausrichtung = ausrichtung;
	}

	/**
	 * Fuegt ein Event zur EventListe und zur Finanzliste hinzu.
	 * @param ev != null
	 * @return true wenn es zu beiden Listen erfolgreich hinzugefuegt wurde.
	 */
	public boolean addEvent(Event ev) {
		return events.add(ev) && finanzen.add(ev);
	}

	/**
	 * Liefert alle Events der Event Liste.
	 * 
	 * Es muss gelten: von < bis
	 * 
	 * @param von != null
	 * @param bis != null
	 * @return die Liste von Events
	 */
	public Collection<Event> getEvents(Date von, Date bis) {
		return events.list(von, bis);
	}

	/**
	 * Liefert Events der Event Liste eines bestimmten Typs.
	 * 
	 * Es muss gelten: von < bis
	 * 
	 * @param von != null
	 * @param bis != null
	 * @param type != null
	 * @return die Liste von Events
	 */
	public Collection<Event> getEvents(Date von, Date bis,
			Class<? extends Event> type) {
		return events.list(von, bis, type);
	}

	/**
	 * Liefert den Eintrag (mit Metainformationen) eines Events.
	 * @param event
	 * @return null falls event nicht in der Liste ist, andernfallse den zugehoerigen Eintrag.
	 */
	public Entry<Event> getEventEntry(Event event) {
		return events.find(event);
	}

	/**
	 * Fuegt ein Mitglied der Mitgliederliste hinzu.
	 * @param member != null
	 * @return true wenn es erfolgreich hinzugefuegt wurde
	 */
	public boolean addMember(Mitglied member) {
		return addMember(member, new Date());
	}
	
	/**
	 * Fuegt ein Mitglied zu einem bestimmten Eintrittsdatum hinzu.
	 * @param member != null
	 * @param time != null
	 * @return true wenn es erfolgreich hinzugefuegt wurde
	 */
	public boolean addMember(Mitglied member, Date time) {
		if(mitglieder.add(member, time)) {
			events.addObserver(member);
			return true;
		}
		
		return false;
	}

	/**
	 * Entfernt ein Mitglied mit einem bestimmten Austrittsdatum.
	 * @param member != null
	 * @param time != null
	 * @return true falls das Mitglied erfolgreich geloescht wurde
	 */
	public boolean removeMember(Mitglied member, Date time) {
		if(mitglieder.remove(member, time)) {
			events.removeObserver(member);
			return true;
		}
		
		return false;
	}

	/**
	 * Fuegt ein Lied zu einem gegebenen Einfuegedatum zum Repertoire hinzu.
	 * @param lied != null
	 * @param time != null
	 * @return true falls das Lied erfolgreich hinzugefuegt wurde
	 */
	public boolean addSong(Lied lied, Date time) {
		return repertoire.add(lied, time);
	}

	/**
	 * Entfernt ein Lied zu einem gegebenen Loeschdatum vom Repertoire.
	 * @param lied != null
	 * @param time != null
	 * @return true falls das Lied erfolgreich geloescht wurde
	 */
	public boolean removeSong(Lied lied, Date time) {
		return repertoire.remove(lied, time);
	}

	/**
	 * Liefert alle Mitglieder in der Mitgliederliste.
	 * @return eine Liste aller Mitglieder.
	 */
	public Collection<Mitglied> getMembers() {
		return mitglieder;
	}

	/**
	 * Liefert alle Mitglieder die zu einem gegeben Zeitpunkt in der Liste waren.
	 * @param time != null
	 * @return alle Mitglieder der Liste zu einem gegebenen Zeitpunkt.
	 */
	public Collection<Entry<Mitglied>> getMembers(Date time) {
		return mitglieder.list(time);
	}

	/**
	 * Liefert alle Lieder im Repertoire.
	 * @return eine Liste aller Lieder im Repertoire.
	 */
	public Collection<Lied> getSongs() {
		return repertoire;
	}

	/**
	 * Liefert alle Lieder die zu einem gegebenen Zeitpunkt im Repertoire waren.
	 * @param time != null
	 * @return eine Liste aller Lieder im Repertoire zu einem gegebenen Zeitpunkt.
	 */
	public Collection<Entry<Lied>> getSongs(Date time) {
		return repertoire.list(time);
	}
	
	/**
	 * Fuegt eine allgemeine Finanz der Finanzverwaltung hinzu.
	 * @param f != null
	 * @return true falls die Finanz erfolgreich hinzugefuet wurde.
	 */
	public boolean addFinanz(AllgemeinFinanzen f) {
		return finanzen.add(f);
	}
	
	/**
	 * Summiert alle Finanzen im angegebenen Zeitraum.
	 * 
	 * Es muss gelten: von < bis
	 * 
	 * @param von != null
	 * @param bis != null
	 * @return
	 */
	public BigDecimal getBilanz(Date von, Date bis) {
		return finanzen.summe(von, bis);
	}
	
	/**
	 * Summiert die Bilanz bestimmter Events im angegebenen Zeitraum.
	 * 
	 * Es muss gelten: von < bis
	 * 
	 * @param von != null
	 * @param bis != null
	 * @param type != null
	 * @return
	 */
	public BigDecimal getBilanz(Date von, Date bis, Class<? extends Event> type) {
		return finanzen.summe(von, bis, type);
	}
	
	/**
	 * Summiert bestimmte Allgemeinen Finanzen im angegebenen Zeitraum.
	 * 
	 * @param von != null
	 * @param bis != null
	 * @param art != null
	 * @return
	 */
	public BigDecimal getBilanz(Date von, Date bis, String art) {
		return finanzen.summe(von, bis, art);
	}
	
	/**
	 * Macht aus einem permanenten Mitglied ein Ersatzmitglied.
	 * @param m != null
	 */
	public void toErsatz(Mitglied m) {
		m.setErsatz(true);
	}
	
	/**
	 * Macht aus einem Ersatzmitglied ein Permanentmitglied.
	 * @param m != null
	 */
	public void toPermanent(Mitglied m) {
		m.setErsatz(false);
	}
	
}
