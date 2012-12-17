class DoppelKeksbackMaschine
        implements BackMaschine<DoppelKeks> {
    public DoppelKeks backe(DoppelKeks vorlage) {
        return new DoppelKeks(vorlage);
    }
}