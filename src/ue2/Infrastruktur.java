package ue2;


public class Infrastruktur {
	
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