import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Instanzen dieser Klasse stellen eine Bestellung dar
 * Eine Bestellung enthaelt eine Liste von Positionen
 */
class Bestellung implements Iterable<Position> {
  
	private List<Position> positions = new ArrayList<Position>();
	private int size = 0;

    /**
     * Fuegt eine Position zur Bestlleung hinzu.
     * @param p != null
     */
    public void add(Position p) {
        positions.add(p);
        size++;
    }

    /**
     * @return Iterator aller Positionen
     */
    public Iterator<Position> iterator() {
        return positions.iterator();
    }

    /**
     * Gibt alle Positionen auf stdout aus.
     */
    public void drucke() {
        for(Position position : positions) {
            System.out.println(position);
        }
    }
    
    /**
     * @return die Anzahl der Positionen in der Bestellung
     */
    public int getSize() {
    	return size;
    }
}
