import java.util.Iterator;

/**
 * Stellt ein geordnetes Map dar.
 *
 * @param <K> Key Typ
 * @param <V> Value Typ
 */
public class OrderedMap<K extends Shorter<K>, V> extends OrderedSet<K> implements IterableIterable<K, V> {
	class Item implements Shorter<Item> {
		private Set<V> items;
		private K value;
		
		public Set<V> getItems() {
			return items;
		}

		public K getValue() {
			return value;
		}

		public Item(K value) {
			this.items = new Set<V>();
			this.value = value;
		}

		@Override
		public boolean shorter(Item other) {
			return this.value.shorter(other.value);
		}
	}
	
	private class OrderedMapIteratorIterator implements MapIterator<K, V> {
		private Iterator<Item> it;
		private Item current;
		
		public OrderedMapIteratorIterator(Iterator<Item> it) {
			this.it = it;
		}
		
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public K next() {
			current = it.next();
			return current.getValue();
		}

		@Override
		public void remove() {
			it.remove();
		}

		@Override
		public InsertIterator<V> iterator() {
			return current.getItems().insertIterator();
		}
	}
	
	private OrderedSet<Item> map;
	
	public OrderedMap() {
		this.map = new OrderedSet<Item>();
	}
	
	@Override
	protected boolean insertElement(K element) {
		return map.insert(new Item(element));
	}
	
	@Override
	protected boolean removeElement(K element) {
		for(Item i : map) {
			if(i.getValue() == element) {
				return map.remove(i);
			}
		}
		
		return false;
	}
	
	@Override
	public MapIterator<K, V> iterator() {
		return new OrderedMapIteratorIterator(map.iterator());
	}
}
