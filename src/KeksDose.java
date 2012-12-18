import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * Instanzen dieser Klasse stellen eine Keksdose dar
 * Die Keksdose enthaelt eine Collection von Keksen
 */
class KeksDose implements Iterable<Keks> {
   
	private Collection<Keks> kekse = new ArrayList<Keks>();
	private int size = 0;

    /**
     * Fuegt einen Keks zur Dose hinzu.
     * @param keks != null
     */
    public void add(Keks keks) {
        kekse.add(keks);
        size++;
    }

    /**
     * @return Iterator ueber alle Kekse der Dose
     */
    public Iterator<Keks> iterator() {
        return kekse.iterator();
    }

    /**
     * Gibt den Inhalt der Dose in stdout aus.
     */
    public void inhalt() {
        for(Keks keks : kekse) {
            System.out.println(keks);
        }
    }
    
    /**
     * @return die Anzahl der Kekse in der Keksdose
     */
    public int getSize() {
    	return size;
    }
}
