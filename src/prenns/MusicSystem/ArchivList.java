package prenns.MusicSystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Eine Liste, welche aktuelle und bereits geloeschte Eintraege enthaelt und sie
 * zu einem gegeben Zeitpunkt liefern kann
 * 
 * @author Alexander Prennsberger
 * @param <E>
 *            value
 */
public class ArchivList<E> implements Archiv<E> {

	// Liste der aktuellen Elemente
	private List<Entry<E>> current;
	private List<Entry<E>> old;

	public ArchivList() {

		this.current = new ArrayList<Entry<E>>();
		this.old = new ArrayList<Entry<E>>();
	}

	/**
	 * Liefert alle Eintraege zu einem bestimmten Zeitpunkt
	 * 
	 * @return Collection<E> mit Eintraegen, die zu einem bestimmten Zeitpunkt
	 *         aktuell waren
	 */
	@Override
	public Collection<E> getOldEntries(Date zeitpunkt) {

		Collection<E> result = new ArrayList<E>();

		for (Entry<E> ent : current) {

			if (ent.getCreated().compareTo(zeitpunkt) <= 0) {
				result.add(ent.getValue());
			}
		}

		for (Entry<E> entr : old) {

			if (entr.getCreated().compareTo(zeitpunkt) <= 0
					&& entr.getDeleted().compareTo(zeitpunkt) >= 0) {
				result.add(entr.getValue());
			}
		}

		return result;
	}

	/**
	 * Liefert alle Eintraege zum jetzigen Zeitpunkt
	 * 
	 * @return Collection<E> mit allen aktuellen Eintraegen
	 */
	public Collection<E> getEntries() {

		ArrayList<E> result = new ArrayList<E>();

		for (Entry<E> e : current) {
			result.add(e.getValue());
		}

		return result;
	}

	@Override
	public boolean add(E elem) {
		return current.add(new Entry<E>(elem));
	}

	/**
	 * Methode zum erstellen eines Eintrages mit Erstellungszeitpunkt
	 * 
	 * @param elem
	 * @param time
	 * @return true if elem was added, false otherwise
	 */
	@Override
	public boolean add(E elem, Date time) {

		return current.add(new Entry<E>(elem, time));
	}

	@Override
	public boolean addAll(Collection<? extends E> coll) {

		Collection<Entry<E>> temp = new ArrayList<Entry<E>>();

		for (E elem : coll) {

			temp.add(new Entry<E>(elem));
		}

		return current.addAll(temp);

	}

	@Override
	public void clear() {

		for (Entry<E> ent : current) {

			remove(ent.getValue());
		}
	}

	@Override
	public boolean contains(Object o) {
		return current.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> coll) {
		return current.contains(coll);
	}

	@Override
	public boolean isEmpty() {
		return current.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {

		Collection<E> temp = new ArrayList<E>();

		for (Entry<E> ent : current) {

			temp.add(ent.getValue());
		}

		return temp.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return this.remove((E) o, new Date());
	}
	
	public boolean remove(T o) {
		remove(o, new Date());
	}

	@Override
	public boolean remove(E elem, Date time) {

		if (elem == null) {
			return false;
		}

		for (Iterator<Entry<E>> iterator = current.iterator(); iterator
				.hasNext();) {

			Entry<E> e = iterator.next();

			if (e.getValue().equals(elem) && old.add(e)) {

				e.setDeleted(time);
				iterator.remove();
				return true;
			} 
		}
		return false;
		
	}

	@Override
	public boolean removeAll(Collection<?> coll) {

		for (Object o : coll) {
			if (!remove(o))
				return false;
		}

		return true;
	}

	@Override
	public boolean retainAll(Collection<?> coll) {
		return current.retainAll(coll);
	}

	@Override
	public int size() {
		return current.size();
	}

	@Override
	public Object[] toArray() {
		return current.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return current.toArray(arg0);
	}

}
