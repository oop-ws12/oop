/**
 * Instanzen dieser Klasse stellen eine verkettete Liste von Traktoren dar
 * @author Alexander Prennsberger
 */
public class TraktorList {
	
	/**
	 * Instanzen dieser Klasse stellen einen Knoten in der TraktorList dar
	 * Jeder Knoten besitzt eine Referenz auf seinen Folgeknoten
	 * @author Alexander Prennsberger
	 */
	private class Node {
		
		private Traktor traktor;
		private Node next;
		
		/**
		 * Initialisiert den Knoten mit den uebergebenen Paramatern
		 * @param traktor != null
		 * @param next der Folgeknoten, ist beim ersten Element der Liste gleich null
		 * @author Alexander Prennsberger
		 */
		private Node(Traktor traktor, Node next) {
			this.traktor = traktor;
			this.next = next;
		}
		
		/**
		 * @return den Traktor, der in diesem Knoten gespeichert ist
		 * @author Alexander Prennsberger
		 */
		private Traktor getElem() {
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
		private Node remove(Traktor target) {
			
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
	protected class TraktorListIterator implements TraktorIterator {

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
		public Traktor next() {
			
			if(node != null) {
				
				Node result = node;
				node = node.getNext();
				
				return result.getElem();
			}
			return null;
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
	protected boolean add(Traktor traktor) {
		
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
		
		Traktor t = this.get(id);	
		
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
	protected Traktor get(int id) {
		
		TraktorIterator it = this.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = it.next();
			
			if(t.getSerial() == id) {
				return t;
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
	private TraktorList filter(Filter filter) {
		
		TraktorList result = new TraktorList();
		
		if(filter == null) {
			return this;
		}
		
		TraktorIterator it = this.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = it.next();
			
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
	protected TraktorList filter(Filter filter1, Filter filter2) {
		
		TraktorList temp = new TraktorList();
		TraktorList result = new TraktorList();
		
		temp = filter(filter1);
		
		if(filter2 == null) {
			return temp;
		}
		
		TraktorIterator it = this.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = it.next();
			
			if(filter2.apply(t.getEinsatzzweck())) {
				result.add(t);
			}
		}
		return result;
	}
		
	/**
	 * Gibt einen TraktorIterator ueber die TraktorList zurueck
	 * @return TraktorIterator
	 * @author Alexander Prennsberger
	 */
	public TraktorIterator iterator() {
		return new TraktorListIterator(head);
	}

}
