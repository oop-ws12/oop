package ue2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Stellt einen Eintrag in einer Liste dar mit Einfuegezeitpunkt dar.
 * 
 * @param <T>
 */
public class Entry<T extends Model<T>> implements Observer<ChangedEvent<T>> {
	public class Revision {
		private Date date;
		private T value;
		public Revision(Date date, T value) {
			this.date = date;
			this.value = value;
		}
		public Date getDate() {
			return date;
		}
		public T getValue() {
			return value;
		}
	}
	
	private T value;
	private Date insertOn;

	private List<Revision> revisions;

	public Entry(T value, Date insert) {
		this.revisions = new ArrayList<Revision>();
		this.value = value;
		this.insertOn = insert;

		value.addObserver(this);
	}

	public Entry(Entry<T> o) {
		this.revisions = o.getRevisions();
		this.value = o.getValue();
		this.insertOn = o.getInsertOn();
	}

	public List<Revision> getRevisions() {
		return Collections.unmodifiableList(revisions);
	}

	public T getValue() {
		return value;
	}

	public Date getInsertOn() {
		return insertOn;
	}

	@Override
	public void before(ChangedEvent<T> event) {
		revisions.add(new Revision(new Date(), event.getObject().copy()));
	}

	@Override
	public void fired(ChangedEvent<T> event) {
	}
}
