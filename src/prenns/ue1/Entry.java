package prenns.ue1;

import java.util.Date;

public class Entry<E> {

	private E value;
	private Date created;
	private Date deleted;

	public Entry(E value) {
		this.value = value;
	}

	public Entry(E value, Date created) {

		this.value = value;
		this.created = created;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted)throws IllegalArgumentException {

		if (created.compareTo(deleted) >= 0)
			throw new IllegalArgumentException("Objekt hat zu diesem Zeitpunkt noch nicht existiert!");

		this.deleted = deleted;
	}

	public E getValue() {
		return value;
	}

	public Date getCreated() {
		return created;
	}

}
