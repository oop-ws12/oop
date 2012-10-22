package ue2;

import java.util.ArrayList;
import java.util.Collection;

public class Ort {

	private class Infrastruktur {
		
		
		private Art type;
		private String anfahrt;
		
		public Infrastruktur(Art type, String anfahrt) {
			
			this.type = type;
			this.anfahrt = anfahrt;
		}

		public Art getType() {
			return type;
		}

		public String getAnfahrt() {
			return anfahrt;
		}	
	}
	
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
		
		
		
		return null;
	}
	
}