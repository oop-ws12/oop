
/**
 * Stellt ein beobachtendes Objekt dar.
 * 
 * @param <T>
 */
public interface Observer<T extends EventArgs> {
	/**
	 * Wird aufgerufen bevor das Event ausloest.
	 * 
	 * @param event
	 */
	void before(T event);

	/**
	 * Wird aufgerufen wenn das Event ausloest.
	 * 
	 * @param event
	 */
	void fired(T event);
}
