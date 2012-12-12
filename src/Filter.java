
/**
 * Dieses Interface beschreibt die Methode apply(T t)
 * diese Mehtode vergleicht das aufrufende Objekt mit dem uebergebenen Parameter t 
 */
@Author("Alexander Prennsberger")
interface Filter {

	/**
	 * Diese Methode vergleicht das aufrunde Objekt mit dem Paramater t
	 * @param t != null zu vergleichendes Objekt
	 * @return true, falls die Bedinungen erfuellt sind, false sonst
	 */
	@Author("Alexander Prennsberger")
	boolean apply(Object t);
}
