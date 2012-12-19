/**
 * Stellt ein Postion Visitor dar (Visitor Pattern)
 * @param <T>
 */
interface PositionVisitor<T> {
    /**
     * Aktion fuer Keks.
     * @param p != null
     * @return Ergebniss
     */
    T dispatch(Keks p);

    /**
     * Aktion fuer Doppelkeks.
     * @param p != null
     * @return Ergebniss
     */
    T dispatch(DoppelKeks p);
}
