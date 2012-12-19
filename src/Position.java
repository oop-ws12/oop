/**
 * Instanzen dieser Klasse stellen eine Position fuer einen Keks dar.
 */
class Position {
    
	static class DoppelKeksPosition extends Position {
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
        protected DoppelKeksPosition(int count, Form form, Teigart teigart, Fuellung fuellung) {
            super(count, form, teigart);
            this.fuellung = fuellung;
        }

        /**
         * @return die Beschreibung der Position
         */
        @Override
        public String toString() {
            return String.format("%d x Doppelkeks(%s, %s, %s)", getCount(), getForm(), getTeigart(), getFuellung());
        }

        /**
         * @see Position
         */
        @Override
        public DoppelKeks prototype() {
            return new DoppelKeks(getForm(), getTeigart(), getFuellung());
        }

        /**
         * @see Position
         */
        @Override
        public <T> T visit(PositionVisitor<T> visitor) {
            return visitor.dispatch(this.prototype());
        }
    }

    /**
     * Anzahl > 0
     */
    private int count;

    /**
     * Form
     */
    private Form form;

    /**
     * Teigart
     */
    private Teigart teigart;

    /**
     * @return die Anzahl
     */
    public int getCount() {
        return count;
    }

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
     * Erstellt eine Position
     * @param count > 0
     * @param form != null
     * @param teigart != null
     */
    protected Position(int count, Form form, Teigart teigart) {
        this.count = count;
        this.form = form;
        this.teigart = teigart;
    }

    /**
     * @return Beschreibung der Position
     */
    @Override
    public String toString() {
        return String.format("%d x Keks(%s, %s)", getCount(), getForm(), getTeigart());
    }

    /**
     * @return Einen Prototyp Keks.
     */
    public Keks prototype() {
        return new Keks(form, teigart);
    }

    /**
     * Visit nach dem Visitor Pattern.
     */
    public <T> T visit(PositionVisitor<T> visitor) {
        return visitor.dispatch(this.prototype());
    }

    /**
     * Erezugt eine Position fuer einen einfachen Keks
     * @param count > 0 Anzahl
     * @param form != null Form
     * @param teigart != null Teigart
     * @return die Position
     */
    public static Position create(int count, Form form, Teigart teigart) {
        return new Position(count, form, teigart);
    }

    /**
     * Erezugt eine Position.
     * @param count > 0 Anzahl
     * @param form != null Form
     * @param teigart != null Teigart
     * @param fuellung != null Fuellung
     * @return die Position
     */
    public static Position create(int count, Form form, Teigart teigart, Fuellung fuellung) {
        return new DoppelKeksPosition(count, form, teigart, fuellung);
    }
}
