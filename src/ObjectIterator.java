/**
 * Dieses Interface stellt einen Iterator ueber einen TraktorList dar
 */
@Author("Alexander Prennsberger")
interface ObjectIterator {

	/**
	 * Prueft ob noch ein Object in der Liste vorhanden ist
	 * @return true falls noch ein Object in der Liste, false sonst
	 */
	@Author("Alexander Prennsberger")
	boolean hasNext();
	
	/**
	 * Gibt das naechsten Object in der Liste zurueck
	 * @return das naechste Object
	 */
	@Author("Alexander Prennsberger")
	Object next();
}
