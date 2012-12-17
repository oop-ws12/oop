class EinfacheKeksbackMaschine
        implements BackMaschine<Keks>
{
    /**
     * Backt einen neuen Keks und gibt ihn zurueck.
     * @param keks != null der Vorlagekeks.
     * @return den neuen Keks
     */
    public Keks backe(Keks keks) {
        return new Keks(keks);
    }
}
