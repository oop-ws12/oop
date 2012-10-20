package prenns.MusicSystem;

import java.util.Date;

/**
* @author Alexander Prennsberger
*/
public class Probe extends Event {
	
	private double miete;
	
	public Probe(String ort, Date anfang, Date ende, double miete) {
	
		super(ort, anfang, ende);
		this.miete = miete;
	}
	
	@Override
	public double getBilanz() {
		return -miete;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + "miete = " + miete;
	}
	
	

}
