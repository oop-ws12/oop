package ue2;

/**
 * Stellt ein Objekt dar das beobachtbar ist.
 * @param <T>
 */
public interface Observable<T extends EventArgs> {
	/**
	 * Fuegt einen Beobachter hinzu.
	 * @param observer
	 */
	void addObserver(Observer<T> observer);

	/**
	 * Loescht einen Beobachter.
	 * @param observer
	 */
	void removeObserver(Observer<T> observer);
}
