
/**
 * Dieses EventArgs stellt eine Aenderung eines Objektes dar.
 * 
 * @param <T>
 */
public class ChangedEvent<T> implements EventArgs {
	private T object;
	
	/**
	 * Setzt object auf das uebergebene Objekt
	 * 
	 * @param object != null
	 */
	public ChangedEvent(T object) {
		this.object = object;
	}

	public T getObject() {
		return object;
	}
}
