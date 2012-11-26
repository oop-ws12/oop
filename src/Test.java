
public class Test {
	
	public static int tests = 0;
	public static int success = 0;
	
	static class GesellschafterSoftwareSS1 extends Gesellschafter.BasicSoftware {
		@Override
		public int getStufe() {
			return 1;
		}
	}
	static class BedienerSoftwareSS2 extends Bediener.BasicSoftware {
		@Override
		public int getStufe() {
			return 2;
		}
	}
	
	static class KaempferSoftwareSS5 extends Kaempfer.BasicSoftware {
		@Override
		public int getStufe() {
			return 5;
		}
	}
	
	static class LeibwaechterSoftwareSS4 extends Leibwaechter.BasicSoftware {
		@Override
		public int getStufe() {
			return 4;
		}
	}
	
	public static void main(String[] args) {
		
		testSkins();
		testAuslieferungsListe();
		
		System.out.println();
		System.out.println(String.format("%s/%s", success, tests) + " tests ok! :-)");
	}
	
	public static void testAuslieferungsListe() {
		
		AusgelieferteAndroiden protokoll = new AusgelieferteAndroiden();
		
		SensorAktorKit kit1 = new SensorAktorKit();
		
		kit1.add(new Sensor("Temp"));
		kit1.add(new Aktor("Laser", 5.0));
		kit1.add(new Sensor("Druck"));
		kit1.add(new Aktor("iwas", 0.5));
		
		BehruerungssenstiverSkin behr = new BehruerungssenstiverSkin();
		HochfesterSkin hochf = new HochfesterSkin();
		GepanzerterSkin gep = new GepanzerterSkin();
		
		Kaempfer k1 = new Kaempfer();
		Gesellschafter g1 = new Gesellschafter();
		Leibwaechter l1 = new Leibwaechter();
		
		ok(protokoll.insert(k1, gep, kit1, new KaempferSoftwareSS5()));
		
		/**
		 * In diesem Fall laesst sich der Code gar nicht kompilieren
		 * wird schon zur Compilezeit ueberprueft
		 * diese Kombination wird ueber Wildcards schon verhindert!
		 */
		//ok(!protokoll.insert(new Kaempfer(), gep, kit1, new BedienerSoftwareSS2())));
		
		ok(!protokoll.insert(g1, behr, kit1, new GesellschafterSoftwareSS1()));
		
		
		ok(protokoll.insert(l1, hochf, kit1, new LeibwaechterSoftwareSS4()));
		
		System.out.println(protokoll.find(l1.getSerial()));
				
	}
	
	public static void testSkins() {
		BehruerungssenstiverSkin behr = new BehruerungssenstiverSkin();
		HochfesterSkin hochf = new HochfesterSkin();
		GepanzerterSkin gep = new GepanzerterSkin();
		
		//Bediener benoetigen unbedingt eine beruehrungssensitive Skin
		ok(behr.validate(new Gesellschafter()));
		ok(!hochf.validate(new Hilfskraft()));
		ok(!gep.validate(new Gesellschafter()));
		
		//  nur Beschuetzer duerfen eine gepanzerte Skin haben.
		ok(gep.validate(new Kaempfer()));
		ok(gep.validate(new Leibwaechter()));
		
	}
	
	/**
	 * Prueft zwei Objekte auf Gleicheit.
	 * @param o1
	 * @param o2
	 */
	private static <T> void eq(T o1, T o2) {
		tests++;

		if(!o1.equals(o2)) {
			throw new RuntimeException(String.format("\"%s\" != \"%s\"", o1, o2) + String.format(" %s/%s", success, tests) + " tests ok!" );
		} else {
			success++;
		}
	}
	
	/**
	 * Prueft eine Bedingung.
	 * @param o1
	 * @param o2
	 */
	private static <T> void ok(boolean cond) {
		eq(true, cond);
	}

}
