package ue2;

public class Lied extends Model<Lied> {
	private String name;
	private int duration;

	public Lied(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public Lied copy() {
		return new Lied(name, duration);
	}
}
