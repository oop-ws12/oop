/**
 * Stellt eine sortierte Menge dar.
 *
 * @param <T>
 */
public class OrderedSet<T extends Shorter<? super T>> extends Set<T> {
	@Override
	protected boolean insertElement(T element) {
		// sortiert einfuegen, sortierung ueber item.shorter(other)
		return insertElement(element, getHead());
	}
	
	private boolean insertElement(T item, Entry e) {
		if(item == e.getValue()) return false;
		
		if(e.getNext() == null || item.shorter(e.getNext().getValue())) {
			e.insert(new Entry(item));
			
			return true;
		}
		
		return insertElement(item, e.getNext());
	}
}
