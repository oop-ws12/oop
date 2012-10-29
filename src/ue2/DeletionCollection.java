
import java.util.Collection;
import java.util.Date;

/**
 * Liste welche Abrufen der Elemente (auch geloeschte) zu einem bestimmten
 * Zeitpunkt unterstuetzt.
 */
public interface DeletionCollection<E extends Model<E>> extends Collection<E> {
	/**
	 * Fuegt ein Element zu einem gegebenen Einfuegezeitpunkt hinzu.
	 * 
	 * @param value != null
	 * @param time != null
	 * @return true wenn sich die Collection nach Aufrufen der Methode geaendert hat, false sonst
	 */
	boolean add(E value, Date time);

	/**
	 * Loescht ein Element zu einem gegebenen Loeschzeitpunkt.
	 * 
	 * @param value != null
	 * @param time != null
	 * @return true, wenn sich die Collection nach Aufrufen der Methode geandert hat, false sonst
	 */
	boolean remove(E value, Date time);

	/**
	 * Listet alle Elemente.
	 * 
	 * @return Collection<Entry<E>> aller Elemente in der Collection
	 */
	public Collection<Entry<E>> list();

	/**
	 * Listet alle Elemente die zu einem bestimmten Zeitpunkt vorhanden waren.
	 * 
	 * @param when != null
	 * @return Collection<Entry<E>>
	 */
	public Collection<Entry<E>> list(Date when);

	/**
	 * Liefert den Eintrag zu dem gesuchten Item.
	 * 
	 * @param item != null
	 * @return Entry<E>
	 */
	public Entry<E> find(E item);
}
