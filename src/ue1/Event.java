package ue1;

import java.util.Date;

public abstract class Event {
	private Date beginn;
	private Date ende;
	private String ort;
	
	public Event(String ort, Date beginn, Date end) {
		this.ort = ort;
		this.beginn = beginn;
		this.ende = end;
	}

	public Date getBeginn() {
		return beginn;
	}

	public void setBeginn(Date beginn) {
		this.beginn = beginn;
	}

	public Date getEnde() {
		return ende;
	}

	public void setEnde(Date ende) {
		this.ende = ende;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	/**
	 * Liefert die Gesamtkosten bzw. den Gewinn des Events.
	 * @return Gesamtkosten/Gewinn
	 */
	public abstract double abrechnung();
}
