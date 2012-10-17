package ue1;

import ue1.lists.DeletionCollection;
import ue1.lists.DeletionList;
import ue1.lists.EventList;

/**
 * Stellt eine Musikgruppe dar.
 */
public class MusikGruppe {
	private String name;
	private String ausrichtung;

	private EventList events;
	private DeletionList<Mitglied> mitglieder;
	private DeletionList<Lied> repertoire;

	public MusikGruppe(String name, String ausrichtung) {
		this.name = name;
		this.ausrichtung = ausrichtung;

		this.events = new EventList();
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

	public DeletionCollection<Mitglied> getMitglieder() {
		return mitglieder;
	}

	public DeletionCollection<Lied> getRepertoire() {
		return repertoire;
	}

	public EventList getEvents() {
		return events;
	}
}
