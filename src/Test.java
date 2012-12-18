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
        
        ok(d1.getSize() == 6);
        ok(b1.getSize() == 3);
        
        Bestellung b2 = new Bestellung();
        
        b2.add(Position.create(5, Form.Rund, Teigart.Zimtstern, Fuellung.Marmelade));
        b2.add(Position.create(2, Form.Weihnachtsmann, Teigart.Schokolade, Fuellung.Schokolade));
        b2.add(Position.create(3, Form.Mond, Teigart.Muerb, Fuellung.Marmelade));
        b2.add(Position.create(6, Form.Rund, Teigart.Schokolade));
        
        KeksDose d2 = baeckerei.bestelle(b2);
        
        ok(d2.getSize() == 16);
        ok(b2.getSize() == 4);
        
    }

    private static void print(Bestellung b) {
        System.out.println("Bestellung:");
        b.drucke();
    }

    private static void print(KeksDose b) {
        System.out.println("Keksdose:");
        b.inhalt();
    }
    
   	
    private static <T> void eq(T o1, T o2) {  
   	  	
    	if(!o1.equals(o2)) {
    		throw new RuntimeException(String.format("\"%s\" != \"%s\"", o1, o2));
        }
    }
    
    /**
     * Prueft ob die uebergebene Bedingung wahr ist
     * @param cond die Bedingung
     */
    private static void ok(Boolean cond) {
    	eq(true, cond);
    }
}
