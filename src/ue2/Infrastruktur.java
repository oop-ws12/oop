package ue2;

public class Infrastruktur {

	private EventType type;
	private String anfahrt;

	public Infrastruktur(EventType type, String anfahrt) {

		this.type = type;
		this.anfahrt = anfahrt;
	}

	public EventType getType() {
		return type;
	}

	public String getAnfahrt() {
		return anfahrt;
	}
}