class DoppelKeksbackMaschine<F extends Form, T extends Teigart, V extends Fuellung>
        implements BackMaschine<DoppelKeks<F, T, V>> {
    /**
     * Baeckt einen Doppelkeks mit einer bestimmten Fuellung.
     * @param keks der Vorlagekeks
     * @param f die Fuellung
     * @return den gebackten Doppelkeks
     */
    public DoppelKeks<F, T, V> backe(Keks<F, T> keks, V f) {
        return new DoppelKeks<F, T, V>(keks, f);
    }

    public DoppelKeks<F, T, V> backe(DoppelKeks<F, T, V> vorlage) {
        return new DoppelKeks<F, T, V>(vorlage);
    }
}