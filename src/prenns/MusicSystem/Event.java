package prenns.MusicSystem;

import java.util.Date;

/**
 * @author Alexander Prennsberger
 */
public abstract class Event {

	private String ort;
	private Date anfang;
	private Date ende;
	
	public Event(String ort, Date anfang, Date ende)
			throws IllegalArgumentException {

		this.ort = ort;
		this.anfang = anfang;
		this.ende = ende;

		if (anfang.compareTo(ende) >= 0)
			throw new IllegalArgumentException(
					"Anfangsdatum ist groesser als Enddatum!");
	}
	

	public abstract double getBilanz();

	public void verschiebeAuf(Date begin, Date end) {		
		anfang = begin;
		ende = end;
	}
	
	public String getOrt() {
		return ort;
	}

	public Date getAnfang() {
		return anfang;
	}

	public Date getEnde() {
		return ende;
	}

	@Override
	public String toString() {
		return "ort=" + ort + ", anfang=" + anfang + ", ende=" + ende;
	}

}
