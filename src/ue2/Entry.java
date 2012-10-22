package ue2;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Stellt einen Eintrag in einer Liste dar mit Einfuegezeitpunkt dar.
 * 
 * @param <T>
 */
public class Entry<T extends Model<T>> implements Observer<ChangedEvent<T>> {
	private T value;
	private Date insertOn;

	private Map<Date, T> revisions;

	public Entry(T value, Date insert) {
		this.revisions = new HashMap<Date, T>();
		this.value = value;
		this.insertOn = insert;

		value.addObserver(this);
	}

	public Entry(Entry<T> o) {
		this.revisions = o.getRevisions();
		this.value = o.getValue();
		this.insertOn = o.getInsertOn();
	}

	private Map<Date, T> getRevisions() {
		return Collections.unmodifiableMap(revisions);
	}

	public T getValue() {
		return value;
	}

	public Date getInsertOn() {
		return insertOn;
	}

	@Override
	public void before(ChangedEvent<T> event) {
		revisions.put(new Date(), event.getObject().copy());
	}

	@Override
	public void fired(ChangedEvent<T> event) {
	}
}
