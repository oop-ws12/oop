public interface Shorter<T> {
	/**
	 * Prueft ob die Instanz kuerzer ist als other.
	 * @param other das Objekt mit dem Verglichen wird.
	 * @return true wenn die Instanz kuerzer als other ist
	 */
	boolean shorter(T other);
}
