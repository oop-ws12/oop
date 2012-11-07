
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Stellt einen Eintrag in einer Liste dar mit Einfuegezeitpunkt dar.
 * 
 * @param <T> 
 */
class Entry<T extends Model<T>> implements Observer<ChangedEvent<T>> {
	
	/**
	 * Stellt einen geloeschten Eintrag dar
	 */
	class DeletedEntry extends Entry<T> {
		private Date deletedOn;

		/**
		 * Initialisiert den geloeschten Eintrag
		 * 
		 * @param value != null
		 * @param deleted != null && deleted >= insertOn
		 */
		public DeletedEntry(Entry<T> value, Date deleted) {
			super(value);
			deletedOn = deleted;

			assert getInsertOn().compareTo(deletedOn) <= 0;
		}

		public Date getDeletedOn() {
			return deletedOn;
		}
	}
	
	/**
	 * Stellt eine Rivision des Eintrages dar
	 * Wurde ein Eintrag geaendert kann er mehrere Revisionen besitzen
	 *
	 */
	class Revision {
		
		private Date date;
		private T value;
		
		/**
		 * Initialisiert die Rivision
		 * 
		 * @param date != null
		 * @param value != null
		 */
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

	/**
	 * Initialisiert den Eintrag
	 * 
	 * @param value != null
	 * @param insert != null
	 */
	public Entry(T value, Date insert) {
		this.revisions = new ArrayList<Revision>();
		this.value = value;
		this.insertOn = insert;

		value.addObserver(this);
	}

	/**
	 * Konstruktor zum Kopieren eines Eintrags
	 * 
	 * @param o != null
	 */
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
