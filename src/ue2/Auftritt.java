package ue2;

import java.util.Date;

public class Auftritt extends Event {
	private double gage;
	
	public Auftritt(String ort, Date beginn, Date end, double gage) {
		super(ort, beginn, end);
		this.gage = gage;
	}

	public double getGage() {
		return gage;
	}

	public void setGage(double gage) {
		this.gage = gage;
	}

	@Override
	public double abrechnung() {
		return gage;
	}
}
