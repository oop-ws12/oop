/**
 * Instanzen dieser Klasse stellen eine Liste von Bauernhoefen dar
 */
@Author("Alexander Prennsberger")
public class BauernhofList extends ObjectList {

	/**
	 * Liefert den Bauernhof, dessen Name mit dem uebergebenen Namen uebereinstimmt
	 * @param name der zu suchende Bauernhof
	 * @return den Bauernhof oder null falls kein Bauernhof mit diesem Namen existiert
	 */
	@Author("Alexander Prennsberger")
	protected Object get(String name) {
		
		ObjectIterator it = this.iterator();
		
		while(it.hasNext()) {
			
			Bauernhof b = (Bauernhof) it.next();
			
			if(b.getName().equals(name)){
				return b;
			}
		}
		return null;	
	}
	
	/**
	 * Entfernt den Bauernhof, dessen Name mit dem uebergebenen Namen uebereinstimmt
	 * @param name Name des Bauernhofs, welcher zu loeschen ist
	 * @return true falls die Liste nach Mehtodenaufruf verandert wurde, false sonst
	 */
	@Author("Alexander Prennsberger")
	protected boolean remove(String name) {
		
		Object t = this.get(name);	
		
		if(t != null && head != null) {
			head = head.remove(t);
			return true;
		}
		return false;
	}
}
