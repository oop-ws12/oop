/**
 * Stellt eine sortierte Menge dar.
 *
 * @param <T>
 */
public class OrderedSet<T extends Shorter<T>> extends Set<T> {
	@Override
	public boolean insert(T item) {
		// sortiert einfuegen, sortierung ueber item.shorter(other)
		return false;
	}
	
	// der iterator kann von der unterklasse verwendet werden wenn insert gleich sortiert einfuegt
	// also braucht die methode nicht ueberschrieben werden
}
