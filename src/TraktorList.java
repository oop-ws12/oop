import java.util.Iterator;

/**
 * Instanzen dieser Klasse stellen eine verkettete Liste von Traktoren dar
 * @author Alexander Prennsberger
 */
public class TraktorList<T extends Traktor> implements Iterable<T> {
	
	/**
	 * Instanzen dieser Klasse stellen einen Knoten in der TraktorList dar
	 * Jeder Knoten besitzt eine Referenz auf seinen Folgeknoten
	 * @author Alexander Prennsberger
	 */
	private class Node {
		
		private T traktor;
		private Node next;
		
		/**
		 * Initialisiert den Knoten mit den uebergebenen Paramatern
		 * @param traktor != null
		 * @param next der Folgeknoten, ist beim ersten Element der Liste gleich null
		 * @author Alexander Prennsberger
		 */
		private Node(T traktor, Node next) {
			this.traktor = traktor;
			this.next = next;
		}
		
		/**
		 * @return den Traktor, der in diesem Knoten gespeichert ist
		 * @author Alexander Prennsberger
		 */
		private T getElem() {
			return traktor;
		}
		
		/**
		 * @return die Referenz auf den Folgeknoten dieses Knotens
		 * @author Alexander Prennsberger
		 */
		private Node getNext() {
			return next;
		}
		
		/**
		 * Entfernt den uebergebenen Traktor aus der Liste
		 * @param target der zu entfernende Traktor
		 * @return die Referenz auf den nachfolgenden Knoten von target, ist diese null dann
		 * wird this zurueckgegeben
		 * @author Alexander Prennsberger
		 */
		private Node remove(T target) {
			
			if(target.equals(traktor)) {
				return next;
			}
			else if(next != null) {
				next = next.remove(target);
			}
			return this;	
		}
	}
	
	/**
	 * Instanzen dieser Klasse stellen einen Iterator ueber die TraktorList dar
	 * @author Alexander Prennsberger
	 */
	private class TraktorListIterator implements Iterator<T> {

		private Node node;
		
		/**
		 * Initialisiert den Iterator mit dem Anfangsknoten der Liste
		 * @param node != null Anfangsknoten der Liste
		 */
		private TraktorListIterator(Node node) {
			this.node = node;
		}
		
		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public T next() {
			
			if(node != null) {
				
				Node result = node;
				node = node.getNext();
				
				return result.getElem();
			}
			return null;
		}

		//NOT SUPPORTED
		@Override
		public void remove() {
			
		}	
	}
	
	/**
	 * Anfang der Liste
	 */
	private Node head = null;
	
	/**
	 * Fuegt einen neuen Traktor am Anfang der Liste ein
	 * @param traktor != null
	 * @return true falls die Liste nach Aufruf der Methode geaendert wurde, false sonst
	 * @author Alexander Prennsberger
	 */
	protected boolean add(T traktor) {
		
		if(traktor != null) {
			head = new Node(traktor, head);
			return true;
		}
		return false;
	}
	
	/**
	 * Entfernt den Traktor mit der angegebenen Seriennummer aus der Liste
	 * Existiert der Traktor nicht, dann geschieht nichts 
	 * @param id darf nicht negativ sein
	 * @return true falls die Liste nach Aufruf der Methode geaendert wurde, false sonst
	 * @author Alexander Prennsberger
	 */
	protected boolean remove(int id) {
		
		T t = this.get(id);	
		
		if(t != null && head != null) {
			head = head.remove(t);
			return true;
		}
		return false;
	}
	
	/**
	 * Liefert den Traktor mit der angegeben Seriennummer
	 * @param id Seriennummer des Traktors
	 * @return den Traktor falls er existiert, null sonst
	 * @author Alexander Prennsberger
	 */
	protected T get(int id) {
		
		for(T elem : this) {
		
			if(elem.getSerial() == id) {
				return elem;
			}
		}
		return null;
	}
		
	/**
	 * Filter die TraktorList mittels des angegebenen Filters
	 * @param filter verwendeter Filter, null fuer alle Elemente
	 * @return eine neuen TraktorList, welche nur Elemente enthealt, welche dem Filter entsprechen
	 * @author Alexander Prennsberger
	 */
	private TraktorList<T> filter(Filter<T> filter) {
		
		TraktorList<T> result = new TraktorList<T>();
		
		if(filter == null) {
			return this;
		}
		
		for(T t : this) {
			
			if(filter.apply(t)) {
				result.add(t);
			}
		}
		return result;
	}
	
	/**
	 * Filter die TraktorList mittels der zwei angegebenen Filter
	 * @param filter1 Filter fuer Motortyp, null fuer alle
	 * @param filter2 Filter fuer Einsatzzweck, null fuer alle
	 * @return eine neue TraktorList, welche nur mehr Elemente enthealt, nach denen gefiltert wurde
	 * @author Alexander Prennsberger
	 */
	protected TraktorList<T> filter(Filter<T> filter1, Filter<Einsatzzweck> filter2) {
		
		TraktorList<T> temp = new TraktorList<T>();
		TraktorList<T> result = new TraktorList<T>();
		
		temp = filter(filter1);
		
		if(filter2 == null) {
			return temp;
		}
		
		for(T t : temp) {
			
			if(filter2.apply(t.getEinsatzzweck())) {
				result.add(t);
			}
		}
		return result;
	}
		
	/**
	 * Gibt einen Iterator ueber die TraktorList zurueck
	 * @retrun TraktorListIterator
	 * @author Alexander Prennsberger
	 */
	public Iterator<T> iterator() {
		return new TraktorListIterator(head);
	}

}
