package ue2;

import java.util.Date;

/**
 * Stellt einen geloeschten Eintrag in einer Liste dar.
 * 
 * @param <T>
 */
public class DeletedEntry<T extends Model<T>> extends Entry<T> {
	private Date deletedOn;

	public DeletedEntry(Entry<T> value, Date deleted) {
		super(value);
		deletedOn = deleted;

		assert getInsertOn().compareTo(deletedOn) <= 0;
	}

	public Date getDeletedOn() {
		return deletedOn;
	}
}