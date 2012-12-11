/**
 * Instanzen dieser Klasse stellen eine verkettete Liste von Traktoren dar
 */
@Author("Alexander Prennsberger")
abstract class ObjectList {
	
	/**
	 * Instanzen dieser Klasse stellen einen Knoten in der TraktorList dar
	 * Jeder Knoten besitzt eine Referenz auf seinen Folgeknoten
	 */
	@Author("Alexander Prennsberger")
	class Node {
		
		private Object traktor;
		private Node next;
		
		/**
		 * Initialisiert den Knoten mit den uebergebenen Paramatern
		 * @param traktor != null
		 * @param next der Folgeknoten, ist beim ersten Element der Liste gleich null
		 */
		@Author("Alexander Prennsberger")
		Node(Object traktor, Node next) {
			this.traktor = traktor;
			this.next = next;
		}
		
		/**
		 * @return den Traktor, der in diesem Knoten gespeichert ist
		 */
		@Author("Alexander Prennsberger")
		Object getElem() {
			return traktor;
		}
		
		/**
		 * @return die Referenz auf den Folgeknoten dieses Knotens
		 */
		@Author("Alexander Prennsberger")
		Node getNext() {
			return next;
		}
		
		/**
		 * Entfernt den uebergebenen Traktor aus der Liste
		 * @param target der zu entfernende Traktor
		 * @return die Referenz auf den nachfolgenden Knoten von target, ist diese null dann
		 * wird this zurueckgegeben
		 */
		@Author("Alexander Prennsberger")
		Node remove(Object target) {
			
			size--;
			
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
	 * Instanzen dieser Klasse stellen einen Iterator ueber die ObjectList dar
	 */
	@Author("Alexander Prennsberger")
	private class ObjectListIterator implements ObjectIterator {

		private Node node;
		
		/**
		 * Initialisiert den Iterator mit dem Anfangsknoten der Liste
		 * @param node != null Anfangsknoten der Liste
		 */
		@Author("Alexander Prennsberger")
		private ObjectListIterator(Node node) {
			this.node = node;
		}
		
		@Author("Alexander Prennsberger")
		public boolean hasNext() {
			return node != null;
		}

		@Author("Alexander Prennsberger")
		public Object next() {
			
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
	protected Node head = null;
	
	/**
	 * Die groesse der Liste
	 */
	private int size = 0;
	
	/**
	 * Fuegt einen neuen Traktor am Anfang der Liste ein
	 * @param traktor != null
	 * @return true falls die Liste nach Aufruf der Methode geaendert wurde, false sonst
	 */
	@Author("Alexander Prennsberger")
	protected boolean add(Object traktor) {
		
		if(traktor != null) {
			head = new Node(traktor, head);
			this.size++;
			return true;
		}
		return false;
	}
	
	protected int size() {
		return this.size;
	}
	
	/**
	 * Gibt einen TraktorIterator ueber die TraktorList zurueck
	 * @return TraktorIterator
	 */
	@Author("Alexander Prennsberger")
	public ObjectIterator iterator() {
		return new ObjectListIterator(head);
	}

}
