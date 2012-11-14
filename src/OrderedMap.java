import java.util.Iterator;

/**
 * Stellt ein geordnetes Map dar.
 *
 * @param <T>
 */
public class OrderedMap<T extends Shorter<T>> extends OrderedSet<T> implements IterableIterable<T> {
	private class OrderedMapIteratorIterator implements IteratorIterator<T> {
		public OrderedMapIteratorIterator(OrderedMap map) {
			
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			
		}

		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	@Override
	public IteratorIterator<T> iterator() {
		return new OrderedMapIteratorIterator(this);
	}
}
