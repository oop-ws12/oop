class EinfacheKeksbackMaschine<F extends Form, T extends Teigart>
        implements BackMaschine<Keks<F, T>>
{
    /**
     * Backt einen neuen Keks und gibt ihn zurueck.
     * @param keks != null der Vorlagekeks.
     * @return den neuen Keks
     */
    public Keks<F, T> backe(Keks<F, T> keks) {
        return new Keks<F, T>(keks);
    }
}
