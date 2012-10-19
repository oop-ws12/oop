package prenns.ue1;

import java.util.Collection;
import java.util.Date;

/**
 * @author Alexander Prennsberger
 */
public class MusikGruppe {

	private String name;
	private String ausrichtung;
	private EventList events;
	private ArchivList<Mitglied> members;
	private ArchivList<Song> repertoire;

	public MusikGruppe(String name, String ausrichtung) {

		this.name = name;
		this.ausrichtung = ausrichtung;
		events = new EventList();
		members = new ArchivList<Mitglied>();
		repertoire = new ArchivList<Song>();

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

	public Collection<Event> getEvents(Date von, Date bis) {
		return events.getEvent(von, bis);
	}

	public Collection<Event> getEvents(Date von, Date bis,
			Class<? extends Event> type) {
		return events.getEvent(von, bis, type);
	}

	public void newMember(Mitglied member, Date time) {
		members.add(member, time);
	}

	public void addSong(Song lied, Date time) {
		repertoire.add(lied, time);
	}

	public Collection<Mitglied> getMembers() {
		return members.getEntries();
	}

	public Collection<Mitglied> getMembers(Date time) {
		return members.getOldEntries(time);
	}

	public Collection<Song> getSongs() {
		return repertoire.getEntries();
	}

	public Collection<Song> getSongs(Date time) {
		return repertoire.getOldEntries(time);
	}
}
