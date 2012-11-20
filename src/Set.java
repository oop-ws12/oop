import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stellt eine Menge dar.
 */
public class Set<T> implements Iterable<T> {
	class Entry {
		private Entry next;
		private Entry before;
		private T value;
		
		public Entry(T value) {
			this.value = value;
		}

		public Entry getBefore() {
			return before;
		}
		
		public void setBefore(Entry before) {
			this.before = before;
		}
		
		public Entry getNext() {
			return next;
		}

		public void setNext(Entry next) {
			this.next = next;
		}

		public T getValue() {
			return value;
		}
		
		/**
		 * Sucht ein Element anhand von Identitaet.
		 * @param item
		 * @return
		 */
		public Entry find(T item) {
			if(item == value) return this;
			if(next != null) return next.find(item);
			return null;
		}
		
		/**
		 * Fuegt ein Entry nach diesem Entry ein.
		 * @param item
		 */
		public void insert(Entry item) {			
			if(getNext() != null) {
				getNext().setBefore(item);
				item.setNext(getNext());
			}
			
			item.setBefore(this);
			setNext(item);
		}
		
		/**
		 * Loescht diesen Eintrag.
		 * Das Element muss ein Element davor besitzen.
		 */
		public void remove() {
			getBefore().setNext(getNext());
			if(getNext() != null) {
				getNext().setBefore(getBefore());
			}
		}
		
		/**
		 * Fuegt ein item am Ende hinzu
		 * @param item != null
		 * @return
		 */
		public boolean add(T item) {
			if(item == value) return false;
			if(next != null) return next.add(item);
			
			insert(new Entry(item));
			return true;
		}
	}
	
	/**
	 * Muss nacheinander auf alle Elemente der Menge in nicht weiter bestimmter Reihenfolge zugegriffen werden kann. 
	 * Der Iterator muss auch remove implementieren und darf keine UnsupportedOperationException werfen.
	 */
	class SetIterator implements InsertIterator<T> {
		private Entry e;
		private Entry next;
		
		public SetIterator(Entry first) {
			this.e = first;
			
			if(first != null) {
				this.next = first.getNext();
			}
		}
		
		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public T next() {
			if(next == null) {
				throw new NoSuchElementException();
			}
			
			e = next;
			next = next.getNext();
			return e.getValue();
		}

		@Override
		public void remove() {
			e.remove();
		}
		
		public boolean add(T item) {
			e.insert(new Entry(item));
			return true;
		}
	}
	
	private Entry head;
	private int count;
	
	/**
	 * @return the head
	 */
	protected Entry getHead() {
		return head;
	}
	
	public Set() {
		count = 0;
		head = new Entry(null);
	}
	
	/**
	 * Liefert die Anzahl der Elemente.
	 * @return
	 */
	public int count() {
		return count;
	}

	protected boolean insertElement(T element)
	{
		return head.add(element);
	}
	
	protected boolean removeElement(T element) {
		Entry found = head.find(element);
		if(found == null) return false;
		
		found.remove();
		return true;
	}
	
	/**
	 * Loescht ein Item aus dem Set.
	 * @param item != null, das zu loeschende Item.
	 * @return true falls es erfolgreich geloescht wurde.
	 */
	public boolean remove(T item) {
		if(removeElement(item)) {
			count--;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Nimmt ein Argument, das in die Menge eingefuegt wird, 
	 * wenn nicht bereits ein identisches Element vorhanden war.
	 * 
	 * @param item != null, das hinzuzufuegende Item.
	 * @return true falls es eingefuegt wurde
	 */
	public boolean insert(T item) {
		if(insertElement(item)) {
			count++;
			return true;
		}
		
		return false;
	}
	
	@Override
	public Iterator<T> iterator() {
		return insertIterator();
	}
	
	protected InsertIterator<T> insertIterator() {
		return new SetIterator(head);
	}
}
