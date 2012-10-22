package ue2;

import java.util.ArrayList;
import java.util.Collection;

public class Ort {

	private String name;
	private Collection<Infrastruktur> infra;

	public Ort(String name) {

		this.name = name;
		infra = new ArrayList<Infrastruktur>();
	}

	public String getName() {
		return name;
	}

	public boolean addInfra(Art type, String anfahrt) {

		return infra.add(new Infrastruktur(type, anfahrt));
	}

	public Collection<Infrastruktur> getInfra() {

		return new ArrayList<Infrastruktur>(infra);
	}

	public Collection<Infrastruktur> getIdealInfra() {

		Collection<Infrastruktur> result = new ArrayList<Infrastruktur>();

		for (Infrastruktur inf : infra) {

			if (inf.getType().equals("PROBERAUM")) {
				result.add(inf);
			}
		}
		
		return result;
	}

}