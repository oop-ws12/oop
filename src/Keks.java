class Keks {
    /**
     * Die Form des Kekses
     */
    private F form;

    /**
     * Die Teigart des Kekses
     */
    private T teigart;

    /**
     * @return die Form
     */
    public F getForm() {
        return form;
    }

    /**
     * @return die Teigart
     */
    public T getTeigart() {
        return teigart;
    }

    /**
     * Kopierkonstruktor
     * @param keks != null
     */
    Keks(Keks<F, T> keks) {
        this(keks.getForm(), keks.getTeigart());
    }

    /**
     * Erzeugt einen Keks.
     *
     * @param form != null die Form
     * @param teigart != die Teigart
     */
    Keks(F form, T teigart) {
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