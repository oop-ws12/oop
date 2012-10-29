
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Eine Liste welche geloeschte Elemente zu einem gegebenen Zeitpunkt
 * wiederherstellen kann.
 * 
 * @param <T> Type != null
 *           
 */
class DeletionList<T extends Model<T>> implements DeletionCollection<T>, Observable<ChangedEvent<T>> {
	
	/**
	 * Iterator fuer die DeletionList
	 *
	 */
	class DeletionListIterator implements Iterator<T> {
		
		private Iterator<Entry<T>> entries;

		/**
		 * Initialisiert den DeletionListIterator
		 * 
		 * @param entries != null
		 */
		public DeletionListIterator(Iterator<Entry<T>> entries) {
			this.entries = entries;
		}

		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}

		@Override
		public T next() {
			return entries.next().getValue();
		}

		@Override
		public void remove() {
			entries.remove();
		}
	}

	private List<Entry<T>> entries;
	private List<Entry<T>.DeletedEntry> deleted;
	private ObserverList<ChangedEvent<T>> observers;

	/**
	 * Initialisiert die DeletionList
	 */
	public DeletionList() {
		this.entries = new ArrayList<Entry<T>>();
		this.deleted = new ArrayList<Entry<T>.DeletedEntry>();
		this.observers = new ObserverList<ChangedEvent<T>>();
	}

	@Override
	public boolean add(T value) {
		return add((T) value, new Date());
	}

	@Override
	public boolean add(T value, Date time) {
		if (value == null) {
			return false;
		}

		if(entries.add(new Entry<T>(value, time))) {
			value.addObserver(observers);
			return true;
		}
		
		return false;
	}

	@Override
	public Collection<Entry<T>> list() {
		return entries;
	}

	@Override
	public Collection<Entry<T>> list(Date when) {
		List<Entry<T>> all = new ArrayList<Entry<T>>();

		for (Entry<T> d : entries) {
			if (d.getInsertOn().compareTo(when) <= 0) {
				all.add(d);
			}
		}

		for (Entry<T>.DeletedEntry d : deleted) {
			if (d.getInsertOn().compareTo(when) <= 0
					&& d.getDeletedOn().compareTo(when) >= 0) {
				all.add(d);
			}
		}
		return all;
	}
	
	/**
	 * SCHLECHT: 
	 * Remove Methode aus dem Interface Collection<T> wird zwar ueberschrieben,
	 * jedoche unimplementiert gelassen. Kann nicht implementiert werden, da ein Cast benoetigt wird.
	 * Dieser ist jedoch unsicher.
	 */
	@Override
	public boolean remove(Object value) {
		return false;
	}
	
	/**
	 * Loescht das uebergebene Element aus der DeletionList
	 * @param value != null
	 * @return true, falls die List nach Aufruf der Methode geaendert wurde, false sonst
	 */
	public boolean remove(T value) {
		return remove((T) value, new Date());
	}

	/**
	 * Loescht ein Element zu einem gegebenen Zeitpunkt aus der Liste
	 * @param value != null
	 * @param time != null
	 * @return true, falls List nach Aufruf der Mehtode geaendert wurde, false sonst
	 */
	public boolean remove(T value, Date time) {
		if (value == null) {
			return false;
		}

		for (Entry<T> t : entries) {
			if (t.getValue().equals(value) && entries.remove(t)) {
				t.getValue().removeObserver(observers);
				deleted.add(t.new DeletedEntry(t, time));
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (T item : c) {
			if (!add(item)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void clear() {
		for (Entry<T> item : entries) {
			remove(item.getValue());
		}
	}

	@Override
	public boolean contains(Object o) {
		return entries.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return entries.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return entries.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return new DeletionListIterator(entries.iterator());
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for (Object o : c) {
			if (!remove(o)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public int size() {
		return entries.size();
	}

	@Override
	public Object[] toArray() {
		Object[] items = new Object[size()];
		for (int i = 0; i < entries.size(); ++i) {
			items[i] = entries.get(i).getValue();
		}
		return items;
	}

	@Override
	public <E> E[] toArray(E[] a) {
		return entries.toArray(a);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return entries.retainAll(c);
	}

	@Override
	public Entry<T> find(T item) {
		for (Entry<T> t : entries) {
			if (t.getValue() == item) {
				return t;
			}
		}

		for (Entry<T> t : deleted) {
			if (t.getValue() == item) {
				return t;
			}
		}

		return null;
	}

	@Override
	public void addObserver(Observer<ChangedEvent<T>> observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer<ChangedEvent<T>> observer) {
		observers.remove(observer);
	}
}
