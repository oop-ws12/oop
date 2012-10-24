
/**
 * Dieses EventArgs stellt eine Aenderung eines Objektes dar.
 * 
 * @param <T>
 */
public class ChangedEvent<T> implements EventArgs {
	private T object;

	public ChangedEvent(T object) {
		this.object = object;
	}

	public T getObject() {
		return object;
	}
}
