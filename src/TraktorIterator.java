
/**
 * Dieses Interface stellt einen Iterator ueber einen TraktorList dar
 * @author Alexander Prennsberger
 */
public interface TraktorIterator {

	/**
	 * Prueft ob noch ein Traktor in der Liste vorhanden ist
	 * @return true falls noch ein Traktor in der Liste, false sonst
	 * @author Alexander Prennsberger
	 */
	public boolean hasNext();
	
	/**
	 * Gibt den naechsten Traktor in der Liste zurueck
	 * @return den naechsten Traktor
	 * @author Alexander Prennsberger
	 */
	public Traktor next();
}
