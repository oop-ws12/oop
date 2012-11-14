import java.util.Iterator;

public interface InsertIterator<T> extends Iterator<T> {
	/***
	 * Fuegt ein Item an der aktuellen Position hinzu.
	 * @param item
	 * @return true falls es erfolgreich hinzugefuegt wurde.
	 */
	boolean add(T item);
}
