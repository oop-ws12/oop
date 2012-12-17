class DoppelKeks extends Keks {
    /**
     * Die Fuellung des Keks.
     */
    private Fuellung fuellung;

    /**
     * @return die Fuellung
     */
    public Fuellung getFuellung() {
        return fuellung;
    }

    /**
     * Erzeugt einen neuen Keks aus einem einfachen
     * mit einer bestimmten Fuellung
     * @param keks != null der alte Keks
     * @param f != null dei Fuellung
     */
    DoppelKeks(Keks keks, Fuellung f) {
        this(keks.getForm(), keks.getTeigart(), f);
    }

    /**
     * Kopiert einen Keks.
     * @param keks != null der alte Keks
     */
    DoppelKeks(DoppelKeks keks) {
        // Kein deep copy noetig weil die zu kopierenden
        // member immutable sind
        this(keks.getForm(), keks.getTeigart(), keks.getFuellung());
    }

    /**
     * Erzeugt einen Doppelkeks.
     *
     * @param form != null die Form
     * @param teigart != die Teigart
     * @param fuellung != null die Fuellung
     */
    DoppelKeks(Form form, Teigart teigart, Fuellung fuellung) {
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
