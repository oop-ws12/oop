package ue2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Lied extends Model<Lied> {
	private String name;
	private int duration;
	
	private Map<String, Integer> varianten;

	public Lied(String name, int duration) {
		this.name = name;
		this.duration = duration;
		this.varianten = new HashMap<String, Integer>();+
		this.varianten.put(name, duration);
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

	public Map<String, Integer> getVarianten() {
		return Collections.unmodifiableMap(varianten);
	}

	public void addVariante(String name, int duration) {
		this.varianten.put(name, duration);
	}

	@Override
	public Lied copy() {
		return new Lied(name, duration);
	}

	@Override
	public String toString() {
		return "Lied [" + name + ", duration=" + duration + 
				(varianten.size() > 1 ? (", " + varianten.size() + " Varianten") : "") +"]";
	}
}
