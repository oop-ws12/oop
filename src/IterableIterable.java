/**
 * Stellt ein Iterable dar, welche einen IteratorIterator als Iterator bereitstellt.
 *
 * @param <T>
 */
public interface IterableIterable<T> extends Iterable<T> {
	@Override
	public IteratorIterator<T> iterator();
}
