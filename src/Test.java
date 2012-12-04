
public class Test {
	
	public static int tests = 0;
	public static int success = 0;
	
	public static void main(String[] args) {
		
		long zstVorher;
		long zstNachher;
		
		zstVorher = System.currentTimeMillis();
		
		testMove();
		System.out.println("Starte Testlauf 1: ");
		testlauf1();
		
		
		zstNachher = System.currentTimeMillis();
		
		System.out.println(String.format("%s Millisekunden fuer Termination gebraucht", zstNachher - zstVorher));
		System.out.println(String.format("%s/%s Tests erfolgreich!", success, tests));
		
	}
	
	private static void testlauf1() {
		
		Game game = new Game(10, 5);
		
		for(int i = 0; i < 1; i++) {
			new FastCar(game, new MoveStrategy.Random(FastCar.getValidMoves()));
		}
		
		for(int i = 0; i < 1; i++) {
			Car f = new FastCar(game, new MoveStrategy.Always(Move.FWD));
			f.setAngle(new java.util.Random().nextBoolean() ? 90: 180);
		}
		
		game.start();
		
	}
	
	private static void testMove() {
		
		eq(Move.FWD.getPositionDelta(0).toString(), "Point(1, 0)");
		eq(Move.FWD.getPositionDelta(90).toString(), "Point(0, -1)");
		
		eq(Move.FWDLEFT.getPositionDelta(0).toString(), "Point(1, -1)");
		eq(Move.FWDLEFT.getPositionDelta(90).toString(), "Point(-1, -1)");
		
		eq(Move.LEFT.getPositionDelta(270).toString(), "Point(1, 0)");
	}
	
	/**
	 * Prueft zwei Objekte auf Gleicheit.
	 * @param o1
	 * @param o2
	 */
	private static <T> void eq(T o1, T o2) {	
		tests++;
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
		eq(true, cond);
	}
}
