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

    /**
     * @return Beschreibung der Position
     */
    @Override
    public String toString() {
        return String.format("%d x Doppelkeks(%s, %s, %s)", getCount(), getForm(), getTeigart(), getFuellung());
    }

    @Override
    public DoppelKeks prototype() {
        return new DoppelKeks(getForm(), getTeigart(), getFuellung());
    }

    @Override
    public <T> T visit(PositionVisitor<T> visitor) {
        return visitor.dispatch(this);
    }
}