class Baeckerei {
    private EinfacheKeksbackMaschine einfacheKeksbackMaschine = new EinfacheKeksbackMaschine();
    private DoppelKeksbackMaschine doppelKeksbackMaschine = new DoppelKeksbackMaschine();

    class Baecker implements PositionVisitor<Keks> {
        Position position;

        Baecker(Position position) {
            this.position = position;
        }

        public Keks backe() {
            return position.visit(this);
        }

        public Keks dispatch(Position p) {
            return einfacheKeksbackMaschine.backe(p.prototype());
        }

        public Keks dispatch(DoppelKeksPosition p) {
            return doppelKeksbackMaschine.backe(p.prototype());
        }
    }

    public KeksDose bestelle(Bestellung bestellung) {
        KeksDose dose = new KeksDose();
        for(Position position : bestellung) {
            Baecker baecker = new Baecker(position);

            for(int i = 0, count = position.getCount(); i < count; i++) {
                dose.add(baecker.backe());
            }
        }

        return dose;
    }
}
