package ue1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Eine Liste welche gelöschte Elemente zu einem gegebenen Zeitpunkt wiederherstellen kann.
 *
 * @param <T> Type
 */
public class DeletionList<T> {
	public class Entry {
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
	
	public class DeletedEntry extends Entry {
		private Date deletedOn;

		public DeletedEntry(Entry value, Date deleted) {
			super(value.getValue(), value.getInsertOn());
			deletedOn = deleted;

			assert getInsertOn().compareTo(deletedOn) <= 0;
		}
	
		public Date getDeletedOn() {
			return deletedOn;
		}
	}

	private List<Entry> entries;
	private List<DeletedEntry> deleted;
	
	public DeletionList() {
		this.entries = new ArrayList<Entry>();
		this.deleted = new ArrayList<DeletedEntry>();
	}
	
	/**
	 * Fügt ein Element hinzu.
	 * @param value
	 */
	public void add(T value) {
		add(value, new Date());
	}
	
	/**
	 * Fügt ein Element mit dem gegeben Einfügezeitpunkt hinzu.
	 * @param value
	 * @param time
	 */
	public void add(T value, Date time) {
		entries.add(new Entry(value, time));
	}
	
	/**
	 * Liefert alle Elemente zu einem gegebenen Zeitpunkt.
	 * @param when Zeitpunkt
	 * @return
	 */
	public Collection<Entry> list(Date when) {
		List<Entry> all = new ArrayList<Entry>();
		
		for(Entry d : entries) {
			if(d.getInsertOn().compareTo(when) <= 0) {
				all.add(d);
			}
		}
		
		for(DeletedEntry d : deleted) {
			if(d.getInsertOn().compareTo(when) <= 0 && d.getDeletedOn().compareTo(when) >= 0) {
				all.add(d);
			}
		}
		return all;
	}
	
	/**
	 * Listet alle Elemente der Liste die jetzt gerade vorhanden sind.
	 * @return
	 */
	public Collection<Entry> list() {
		return entries;
	}
	
	/**
	 * Löscht ein Element.
	 * @param value
	 * @return
	 */
	public boolean remove(T value) {
		return remove(value, new Date());
	}
	
	/**
	 * Löscht ein Element zu einem gegebenen Löschzeitpunkt.
	 * @param value
	 * @param time
	 * @return
	 */
	public boolean remove(T value, Date time) {
		for(Entry t : entries) {
			if(t.getValue().equals(value) && entries.remove(t)) {
				deleted.add(new DeletedEntry(t, time));
				return true;
			}
		}
		
		return false;
	}
}