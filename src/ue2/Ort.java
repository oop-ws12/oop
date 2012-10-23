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

	public boolean addInfra(EventType type, String anfahrt, String beschreibung) {

		return infra.add(new Infrastruktur(type, anfahrt, beschreibung));
	}
	
	/**
	 * Prueft ob der Ort eine geeignet Infrastruktur fuer das uebergebene Event besitzt
	 * @param type Type des Events (Auftritt/Probe)
	 * @return true falls der Ort eine geeignete Infrastuktur bestitzt, false sonst
	 */
	public boolean hasIdealInfra(EventType type) {

		for(Infrastruktur i : infra) {
			
			if(i.getType().equals(type)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Ort [" + name + "]";
	}
}