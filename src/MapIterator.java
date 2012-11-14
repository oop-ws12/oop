import java.util.Iterator;

/**
 * Stellt einen Iterator, dar der auch das Iterieren ueber das aktuelle Objekt unterstuetzt.
 *
 * @param <E>
 */
public interface MapIterator<K, V> extends Iterator<K> {
	/**
	 * Gibt einen Iterator fuer das aktuelle Item zurueck.
	 * @return
	 */
	public InsertIterator<V> iterator();
}
