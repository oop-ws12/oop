package prenns.MusicSystem;

import java.util.Date;

/**
 * @author Alexander Prennsberger
 */
public class Auftritt extends Event {

	private double gage;

	public Auftritt(String ort, Date anfang, Date ende, double gage) {

		super(ort, anfang, ende);
		this.gage = gage;
	}

	@Override
	public double getBilanz() {
		return gage;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + "gage = " + gage;

	}

}
