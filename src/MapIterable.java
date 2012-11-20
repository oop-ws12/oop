/**
 * Stellt ein Iterable dar, welche einen MapIterator als Iterator bereitstellt.
 *
 * @param <T>
 */
public interface MapIterable<K, V> extends Iterable<K> {
	@Override
	public MapIterator<K, V> iterator();
}
