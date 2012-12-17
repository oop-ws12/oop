/**
 * Position fuer einen einfachen Keks.
 */
class Position {
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
    Position(int count, Form form, Teigart teigart) {
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

    public <T> T visit(PositionVisitor<T> visitor) {
        return visitor.dispatch(this);
    }
}
