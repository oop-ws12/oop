
public class Test {
	class GesellschafterSoftwareSS1 extends Gesellschafter.BasicSoftware {
		@Override
		public int getStufe() {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		BehruerungssenstiverSkin behr = new BehruerungssenstiverSkin();
		HochfesterSkin hochf = new HochfesterSkin();
		GepanzerterSkin gep = new GepanzerterSkin();
		
		//Bediener benoetigen unbedingt eine beruehrungssensitive Skin
		ok(behr.validate(new Gesellschafter()));
		ok(!hochf.validate(new Hilfskraft()));
		ok(!gep.validate(new Gesellschafter()));
		
		//  nur Beschuetzer dürfen eine gepanzerte Skin haben.
		ok(gep.validate(new Kaempfer()));
		ok(gep.validate(new Leibwaechter()));
		
		System.out.println();
		System.out.println("All tests ok! :-)");
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
			System.out.print(".");
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
