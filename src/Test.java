public class Test {
    public static void main(String[] args) {
        Baeckerei baeckerei = new Baeckerei();

        Bestellung b1 = new Bestellung();
        b1.add(Position.create(3, Form.Rund, Teigart.Schokolade));
        b1.add(Position.create(1, Form.Weihnachtsmann, Teigart.Zimtstern));

        b1.add(Position.create(2, Form.Mond, Teigart.Muerb, Fuellung.Schokolade));
        print(b1);

        KeksDose d1 = baeckerei.bestelle(b1);
        print(d1);
    }

    private static void print(Bestellung b) {
        System.out.println("Bestellung:");
        b.drucke();
    }

    private static void print(KeksDose b) {
        System.out.println("Keksdose:");
        b.inhalt();
    }
}
