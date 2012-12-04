
public class Test {
	
	public static int tests = 0;
	public static int success = 0;
	
	public static void main(String[] args) {
		
		long zstVorher;
		long zstNachher;
		
		zstVorher = System.currentTimeMillis();
		
		testMove();
		testlauf1();
		testlauf2();
		testlauf3();
		
		zstNachher = System.currentTimeMillis();
		
		System.out.println(String.format("Tests nach %s Millisekunden terminiert", zstNachher - zstVorher));
		System.out.println(String.format("%s/%s Tests erfolgreich!", success, tests));
		
	}
	
	private static void testlauf1() {
		
		System.out.println("Starte Testlauf 1: ");
		
		tests++;
		Game game1 = new Game(10, 5);
		
		for(int i = 0; i < 1; i++) {
			new FastCar(game1, new MoveStrategy.Random(FastCar.getValidMoves()));
		}
		
		for(int i = 0; i < 3; i++) {
			Car f = new FastCar(game1, new MoveStrategy.Always(Move.FWD));
			f.setAngle(new java.util.Random().nextBoolean() ? 90: 180);
		}
		
		game1.start();
		success++;
		
	}
	
	private static void testlauf2() {
	
		System.out.println("Starte Testlauf 2: ");
		tests++;
		Game game2 = new Game(10, 10);
		
		for(int i = 0; i < 20; i++) {
			new FastCar(game2, new MoveStrategy.Always(Move.FWD));
		}
		
		for(int i = 0; i < 10; i++) {
			Car c2 = new MoveCar(game2, new MoveStrategy.Always(Move.FWD));
			c2.setAngle(180);
		}
			
		game2.start();
		success++;
	}
	
	private static void testlauf3() {
		
		System.out.println("Starte Testlauf 3: ");
		tests++;
		Game game3 = new Game(30, 40);
		
		for(int i = 0; i < 30; i++) {
			Car c1 = new FastCar(game3, new MoveStrategy.Random(FastCar.getValidMoves()));
			c1.setAngle(90);
		}
		
		for(int i = 0; i < 10; i++) {
			Car c = new MoveCar(game3, new MoveStrategy.Always(Move.FWD));
			c.setAngle(270);
		}
		game3.start();
		success++;
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
}
