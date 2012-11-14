import java.util.Iterator;

/**
 * Stellt einen Iterator, dar der auch das Iterieren ueber das aktuelle Objekt unterstuetzt.
 *
 * @param <E>
 */
public interface IteratorIterator<E> extends Iterator<E> {
	/**
	 * Gibt einen Iterator fuer das aktuelle Item zurueck.
	 * @return
	 */
	public Iterator<E> iterator();
}
