package ue2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Eine Liste welche geloeschte Elemente zu einem gegebenen Zeitpunkt
 * wiederherstellen kann.
 * 
 * @param <T>
 *            Type
 */
public class DeletionList<T extends Model<T>> implements DeletionCollection<T> {
	public class DeletionListIterator implements Iterator<T> {
		private Iterator<Entry<T>> entries;

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
	private List<DeletedEntry<T>> deleted;

	public DeletionList() {
		this.entries = new ArrayList<Entry<T>>();
		this.deleted = new ArrayList<DeletedEntry<T>>();
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

		return entries.add(new Entry<T>(value, time));
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

		for (DeletedEntry<T> d : deleted) {
			if (d.getInsertOn().compareTo(when) <= 0
					&& d.getDeletedOn().compareTo(when) >= 0) {
				all.add(d);
			}
		}
		return all;
	}

	@Override
	public boolean remove(Object value) {
		try {
			return remove((T) value, new Date());
		} catch (ClassCastException e) {
			return false;
		}
	}

	public boolean remove(T value, Date time) {
		if (value == null) {
			return false;
		}

		for (Entry<T> t : entries) {
			if (t.getValue().equals(value) && entries.remove(t)) {
				deleted.add(new DeletedEntry<T>(t, time));
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
}