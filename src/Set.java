import java.util.Iterator;

/**
 * Stellt eine Menge dar.
 */
public class Set<T> implements Iterable<T> {
	/**
	 * Muss nacheinander auf alle Elemente der Menge in nicht weiter bestimmter Reihenfolge zugegriffen werden kann. 
	 * Der Iterator muss auch remove implementieren und darf keine UnsupportedOperationException werfen.
	 */
	private class SetIterator implements Iterator<T> {
		public SetIterator(Set set) {
			// TODO
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	/**
	 * Loescht ein Item aus dem Set.
	 * @param item das zu loeschende Item.
	 * @return true falls es erfolgreich geloescht wurde.
	 */
	public boolean remove(T item) {
		return false; // benoetigt weil der iterator remove unterstuetzen muss.
	}
	
	/**
	 * Nimmt ein Argument, das in die Menge eingefügt wird, 
	 * wenn nicht bereits ein identisches Element vorhanden war.
	 * 
	 * @param item das hinzuzufuegende Item.
	 * @return true falls es eingefuegt wurde
	 */
	public boolean insert(T item) {
		return true; // TODO
	}
	
	@Override
	public Iterator<T> iterator() {
		return new SetIterator(this);
	}

}
