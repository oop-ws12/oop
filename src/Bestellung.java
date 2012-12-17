import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Bestellung implements Iterable<Position> {
    private List<Position> positions = new ArrayList<Position>();

    /**
     * Fuegt eine Position zur Bestlleung hinzu.
     * @param p != null
     */
    public void add(Position p) {
        positions.add(p);
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
}
