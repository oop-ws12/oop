class Keks {
    /**
     * Die Form des Kekses
     */
    private Form form;

    /**
     * Die Teigart des Kekses
     */
    private Teigart teigart;

    /**
     * @return die Form
     */
    public Form getForm() {
        return form;
    }

    /**
     * @return die Teigart
     */
    public Teigart getTeigart() {
        return teigart;
    }

    /**
     * Kopierkonstruktor
     * @param keks != null
     */
    Keks(Keks keks) {
        // Kein deep copy noetig weil die zu kopierenden
        // member immutable sind
        this(keks.getForm(), keks.getTeigart());
    }

    /**
     * Erzeugt einen Keks.
     *
     * @param form != null die Form
     * @param teigart != die Teigart
     */
    Keks(Form form, Teigart teigart) {
        this.form = form;
        this.teigart = teigart;
    }

    /**
     * @return Beschreibung des Kekses
     */
    @Override
    public String toString() {
        return String.format("Keks(%s, %s)", getForm(), getTeigart());
    }
}