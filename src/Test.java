
public class Test {
	
	public static int tests = 0;
	public static int success = 0;
	
	class GesellschafterSoftwareSS1 extends Gesellschafter.BasicSoftware {
		@Override
		public int getStufe() {
			return 1;
		}
	}
	class BedienerSoftwareSS2 extends Bediener.BasicSoftware {
		@Override
		public int getStufe() {
			return 2;
		}
	}
	
	public static void main(String[] args) {
		
		testSkins();
		
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
		
		//ok(protokoll.insert(new Kaempfer(), gep, kit1, software));
				
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
		if(!o1.equals(o2)) {
			throw new RuntimeException(String.format("\"%s\" != \"%s\"", o1, o2));
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
		tests++;
		eq(true, cond);
	}

}
