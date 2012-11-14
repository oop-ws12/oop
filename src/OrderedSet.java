/**
 * Stellt eine sortierte Menge dar.
 *
 * @param <T>
 */
public class OrderedSet<T extends Shorter<T>> extends Set<T> {
	@Override
	public boolean insert(T item) {		
		// sortiert einfuegen, sortierung ueber item.shorter(other)
		return insert(item, getHead());
	}
	
	private boolean insert(T item, Entry e) {
		if(item == e.getValue()) return false;
		
		if(e.getNext() == null || item.shorter(e.getNext().getValue())) {
			e.insert(new Entry(item));
			
			return true;
		}
		
		return insert(item, e.getNext());
	}
}
