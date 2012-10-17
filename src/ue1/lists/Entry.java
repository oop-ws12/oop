package ue1.lists;

import java.util.Date;

/**
 * Stellt einen Eintrag in einer Liste dar mit Einfuegezeitpunkt dar.
 * 
 * @param <T>
 */
public class Entry<T> {
	private T value;
	private Date insertOn;

	public Entry(T value, Date insert) {
		this.value = value;
		this.insertOn = insert;
	}

	public T getValue() {
		return value;
	}

	public Date getInsertOn() {
		return insertOn;
	}
}
