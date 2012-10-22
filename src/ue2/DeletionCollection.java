package ue2;

import java.util.Collection;
import java.util.Date;

/**
 * Liste welche Abrufen der Elemente (auch geloeschte) zu einem bestimmten
 * Zeitpunkt unterstuetzt.
 */
public interface DeletionCollection<E> extends Collection<E> {
	/**
	 * Fuegt ein Element zu einem gegebenen Einfuegezeitpunkt hinzu.
	 * 
	 * @param value
	 * @param time
	 * @return
	 */
	boolean add(E value, Date time);

	/**
	 * Loescht ein Element zu einem gegebenen Loeschzeitpunkt.
	 * 
	 * @param value
	 * @param time
	 * @return
	 */
	boolean remove(E value, Date time);

	/**
	 * Listet alle Elemente.
	 * 
	 * @param when
	 * @return
	 */
	public Collection<Entry<E>> list();

	/**
	 * Listet alle Elemente die zu einem bestimmten Zeitpunkt vorhanden waren.
	 * 
	 * @param when
	 * @return
	 */
	public Collection<Entry<E>> list(Date when);
}
