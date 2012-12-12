class DoppelKeks<F extends Form, T extends Teigart, V extends Fuellung>
        extends Keks<F, T> implements Cloneable {
    /**
     * Die Fuellung des Keks.
     */
    private V fuellung;

    /**
     * @return die Fuellung
     */
    public V getFuellung() {
        return fuellung;
    }

    /**
     * Erzeugt einen neuen Keks aus einem einfachen
     * mit einer bestimmten Fuellung
     * @param keks != null der alte Keks
     * @param f != null dei Fuellung
     */
    DoppelKeks(Keks<F, T> keks, V f) {
        this(keks.getForm(), keks.getTeigart(), f);
    }

    /**
     * Kopiert einen Keks.
     * @param keks != null der alte Keks
     */
    DoppelKeks(DoppelKeks<F, T, V> keks) {
        this(keks.getForm(), keks.getTeigart(), keks.getFuellung());
    }

    /**
     * Erzeugt einen Doppelkeks.
     *
     * @param form != null die Form
     * @param teigart != die Teigart
     * @param fuellung != null die Fuellung
     */
    DoppelKeks(F form, T teigart, V fuellung) {
        super(form, teigart);
        this.fuellung = fuellung;
    }

    /**
     * @return Beschreibung des Kekses
     */
    @Override
    public String toString() {
        return String.format("DoppelKeks(%s, %s, %s)", getForm(), getTeigart(), getFuellung());
    }
}
