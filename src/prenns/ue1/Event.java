package prenns.ue1;

import java.util.Date;
/**
* @author Alexander Prennsberger
*/
public abstract class Event {
	
	private String ort;
	private Date anfang;
	private Date ende;
	
	public Event(String ort, Date anfang, Date ende)throws IllegalArgumentException {
	
		this.ort = ort;
		this.anfang = anfang;
		this.ende = ende;	
		
		if(anfang.compareTo(ende) >= 0)
			throw new IllegalArgumentException("Anfangsdatum ist groesser als Enddatum!");
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public Date getAnfang() {
		return anfang;
	}

	public void setAnfang(Date anfang) {
		this.anfang = anfang;
	}

	public Date getEnde() {
		return ende;
	}

	public void setEnde(Date ende) {
		this.ende = ende;
	}

	@Override
	public String toString() {
		return "ort=" + ort + ", anfang=" + anfang + ", ende=" + ende;
	}
	
	
}	
