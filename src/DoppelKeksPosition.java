class DoppelKeksPosition extends Position {
    /**
     * Fuellung
     */
    private Fuellung fuellung;

    /**
     * @return die Fuellung
     */
    public Fuellung getFuellung() {
        return fuellung;
    }

    /**
     * Erzeugt eine Postion fuer Doppelkekse
     * @param count > 0
     * @param form != null
     * @param teigart != null
     * @param fuellung != null
     */
    DoppelKeksPosition(int count, Form form, Teigart teigart, Fuellung fuellung) {
        super(count, form, teigart);
        this.fuellung = fuellung;
    }
}