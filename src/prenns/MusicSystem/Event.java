package prenns.MusicSystem;

import java.util.Date;

/**
 * @author Alexander Prennsberger
 */
public class Event {

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
	
	/**
	 *  Kopierkonstruktor
	 *  @param e zu kopierendes Element
	 */
	public Event(Event e) {
		
		this.ort = e.ort;
		this.anfang = e.anfang;
		this.ende = e.ende;
	}
	
	public double getBilanz(){
		return 0.00;
	}

	public void verschiebeAuf(Date time) {		
		anfang = time;
			
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
