package ue2;

import java.util.Date;

/**
 * Stellt einen Auftritt der Musikgruppe dar.
 * 
 */
public class Auftritt extends Event {
	private double gage;
	
	public Auftritt(Ort ort, Date beginn, Date end, double gage) {
		super(ort, beginn, end);
		this.gage = gage;
	}

	public Auftritt(Auftritt o) {
		super(o);
		this.gage = o.gage;
	}

	public double getGage() {
		return gage;
	}

	public void setGage(double gage) {
		this.observers.before(changed);
		this.gage = gage;
		this.observers.fire(changed);
	}

	@Override
	public double abrechnung() {
		return gage;
	}

	@Override
	public String toString() {
		return "Auftritt [gage=" + getGage() + ", ort=" + getOrt() + "]";
	}

	@Override
	public Event copy() {
		return new Auftritt(this);
	}
}
