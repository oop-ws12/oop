package ue2;

/**
 * Repraesentiert ein Objekt das sich selbst kopieren (klonen) kann.
 */
public interface Copyable<T> {
	/**
	 * Kopiert das Objekt.
	 * 
	 * @return das kopierte Objekt.
	 */
	T copy();
}
