/**
 * Stellt ein Iterable dar, welche einen IteratorIterator als Iterator bereitstellt.
 *
 * @param <T>
 */
public interface IterableIterable<K, V> extends Iterable<K> {
	@Override
	public MapIterator<K, V> iterator();
}
