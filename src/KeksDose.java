import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class KeksDose implements Iterable<Keks> {
    private Collection<Keks> kekse = new ArrayList<Keks>();

    /**
     * Fuegt einen Keks zur Dose hinzu.
     * @param keks != null
     */
    public void add(Keks keks) {
        kekse.add(keks);
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
}
