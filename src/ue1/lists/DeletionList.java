package ue1.lists;

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
public class DeletionList<T> implements DeletionCollection<T> {
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

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object value) {
		return add((T) value, new Date());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(T value, Date time) {
		if (value == null) {
			return false;
		}

		return entries.add(new Entry<T>(value, time));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Entry<T>> list() {
		return entries;
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object value) {
		return remove((T) value, new Date());
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (T item : c) {
			if (!add(item)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		for (Entry<T> item : entries) {
			remove(item.getValue());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Object o) {
		return entries.contains(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return entries.containsAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return entries.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<T> iterator() {
		return new DeletionListIterator(entries.iterator());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		for (Object o : c) {
			if (!remove(o)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return entries.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] toArray() {
		Object[] items = new Object[size()];
		for (int i = 0; i < entries.size(); ++i) {
			items[i] = entries.get(i);
		}
		return items;
	}

	/**
	 * Not supported.
	 */
	@Override
	public <E> E[] toArray(E[] a) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not supported.
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
}