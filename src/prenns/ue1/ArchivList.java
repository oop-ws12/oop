package prenns.ue1;

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
 * @param <E> value
 */
public class ArchivList<E> implements Archiv<E> {

	public class Entry {

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

		public void setDeleted(Date deleted) {
			
			assert(created.compareTo(deleted) >= 0);
			
			this.deleted = deleted;
		}

		public E getValue() {
			return value;
		}

		public Date getCreated() {
			return created;
		}

	}

	// Liste der aktuellen Elemente
	private List<Entry> current;
	private List<Entry> old;

	public ArchivList() {

		this.current = new ArrayList<Entry>();
		this.old = new ArrayList<Entry>();
	}

	@Override
	public Collection<E> getOldEntries(Date zeitpunkt) {

		Collection<E> result = new ArrayList<E>();
		
		for(Entry ent : current) {
			
			if(ent.getCreated().compareTo(zeitpunkt) <= 0) {
				
				result.add(ent.getValue());
			}
		}
		
		for(Entry entr : old) {
			
			if(entr.getCreated().compareTo(zeitpunkt) <= 0) {
				
				result.add(entr.getValue());
			}
		}
		
		return result;
	}

	@Override
	public boolean add(E elem) {
		return current.add(new Entry(elem));
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

		return current.add(new Entry(elem, time));
	}

	@Override
	public boolean addAll(Collection<? extends E> coll) {

		Collection<Entry> temp = new ArrayList<Entry>();

		for (E elem : coll) {

			temp.add(new Entry(elem));
		}

		return current.addAll(temp);

	}

	@Override
	public void clear() {
		
		for(Entry ent : current) {
			
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
		
		for(Entry ent : current) {
			
			temp.add(ent.getValue());
		}
		
		return temp.iterator();	
	}

	@Override
	public boolean remove(Object o) {
		return this.remove((E)o, new Date());
	}
	
	@Override
	public boolean remove(E elem, Date time) {
		
		if(elem == null) {
			return false;
		}
		
		for(Entry e : current) {
			
			if(e.getValue().equals(elem)) {
				
				e.setDeleted(time);
				old.add(e);
				current.remove(e);
			}
			else return false;
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> coll) {
		return current.removeAll(coll);
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
