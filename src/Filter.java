
/**
 * Dieses Interface beschreibt die Methode apply(T t)
 * diese Mehtode vergleicht das aufrufende Objekt mit dem uebergebenen Parameter t 
 * @author Alexander Prennsberger
 */
public interface Filter {

	/**
	 * Diese Methode vergleicht das aufrunde Objekt mit dem Paramater t
	 * @param t != null zu vergleichendes Objekt
	 * @return true, falls die Bedinungen erfuellt sind, false sonst
	 * @author Alexander Prennsberger
	 */
	public boolean apply(Object t);
}
