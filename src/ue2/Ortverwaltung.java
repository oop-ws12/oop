package ue2;

import java.util.ArrayList;
import java.util.Collection;

public class Ortverwaltung {

	private Collection<Ort> orte;

	public Ortverwaltung() {

		this.orte = new ArrayList<Ort>();
	}

	public boolean addOrt(String name) {

		return orte.add(new Ort(name));
	}

	public Collection<Ort> getIdealOrte(EventType type) {

		Collection<Ort> result = new ArrayList<Ort>();

		for (Ort o : orte) {

			if (o.hasIdealInfra(type)) {

				result.add(o);
			}
		}

		return result;
	}

	public Collection<Infrastruktur> getImportantInfra(Ort ort) {
		
		return null;
	}
}
