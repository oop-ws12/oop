/**
 * Instanzen dieser Klasse Stellen eine Liste von Traktoren dar
 */
@Author("Alexander Prennsberger")
public class TraktorList extends ObjectList {

	/**
	 * Gibt den Traktor mit der angegebenen Seriennummer zurueck
	 * @param id Seriennummer des Traktors
	 * @return den Traktor oder null falls dieser nicht existiert
	 */
	@Author("Alexander Prennsberger")
	protected Object get(int id) {
		
		ObjectIterator it = this.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = (Traktor)it.next();
			
			if(t.getSerial() == id) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Entfernt den Traktor mit der angegebenen Seriennummer aus der Liste
	 * Existiert der Traktor nicht, dann geschieht nichts 
	 * @param id darf nicht negativ sein
	 * @return true falls die Liste nach Aufruf der Methode geaendert wurde, false sonst
	 */
	@Author("Alexander Prennsberger")
	protected boolean remove(int id) {
		
		Object t = this.get(id);	
		
		if(t != null && head != null) {
			head = head.remove(t);
			return true;
		}
		return false;
	}
	
	/**
	 * Gibt eine neue TraktorList zurueck, welche nur mehr die Traktoren enthaelt, nach denen gefiltert wurde
	 * @param filter1 Filtert den Motortyp des Traktors
	 * @param filter2 Filtert die Einsatzart des Traktors
	 * @return eine neue TraktorList
	 */
	@Author("Alexander Prennsberger")
	protected TraktorList filter(Traktor filter1, Einsatzzweck filter2) {
		
		TraktorList temp = filter(filter1);
		TraktorList result = new TraktorList();
		
		if(filter2 == null) {
			return temp;
		}
		
		ObjectIterator it = this.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = (Traktor)it.next();
			
			if(filter2.apply(t.getEinsatzzweck())) {
				result.add(t);
			}
		}
		return result;
	}
	
	/**
	 * Filtert die TraktorList mit dem angegebenen Filter
	 * @param filter der Filter
	 * @return eine neue TraktorList, in welcher nur Traktoren sind, nach denen gefiltert wurde
	 */
	@Author("Alexander Prennsberger")
	private TraktorList filter(Filter filter) {

		TraktorList result = new TraktorList();
		
		if(filter == null) {
			return this;
		}
		
		ObjectIterator it = this.iterator();
		
		while(it.hasNext()) {
			
			Object t = it.next();
			
			if(filter.apply(t)) {
				result.add(t);
			}
		}
		return result;
	}
}
