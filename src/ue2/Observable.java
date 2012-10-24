
/**
 * Stellt ein Objekt dar das beobachtbar ist.
 * @param <T>
 */
public interface Observable<T extends EventArgs> {
	/**
	 * Fuegt einen Beobachter hinzu.
	 * @param observer != null
	 */
	void addObserver(Observer<T> observer);

	/**
	 * Loest einen Beobachter.
	 * @param observer != null
	 */
	void removeObserver(Observer<T> observer);
}
