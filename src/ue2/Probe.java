package ue2;

import java.util.Date;

public class Probe extends Event {
	private double raumMiete;

	public Probe(String ort, Date beginn, Date end, double raumMiete) {
		super(ort, beginn, end);
		this.raumMiete = raumMiete;
	}

	public double getRaumMiete() {
		return raumMiete;
	}

	public void setRaumMiete(double raumMiete) {
		this.raumMiete = raumMiete;
	}

	@Override
	public double abrechnung() {
		return -raumMiete;
	}

	@Override
	public String toString() {
		return "Probe [raummiete=" + getRaumMiete() + ", ort=" + getOrt() + "]";
	}

}
