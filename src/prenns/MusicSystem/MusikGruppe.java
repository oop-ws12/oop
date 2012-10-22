package prenns.MusicSystem;

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

	public boolean newMember(Mitglied member, Date time) {
		return members.add(member, time);
	}

	public boolean removeMember(Mitglied member, Date time) {
		return members.remove(member, time);
	}

	public boolean newSong(Song lied, Date time) {
		return repertoire.add(lied, time);
	}

	public boolean removeSong(Song lied, Date time) {
		return repertoire.remove(lied, time);
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

	public double getBilanz(Date von, Date bis) {
		return events.getBilanz(von, bis);
	}

	public double getBilanz(Date von, Date bis, Class<? extends Event> type) {
		return events.getBilanz(von, bis, type);
	}

	@Override
	public String toString() {

		return "Name= " + name + ", " + "Ausrichtung= " + ausrichtung;
	}
}
