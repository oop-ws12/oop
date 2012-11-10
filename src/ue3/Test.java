
public class Test {
	public static void main(String[] args) {
		testBox();
		testClearBox();
		testDarkBox();
		testFreeBox();
		
		System.out.println();
		System.out.println("All tests ok.");
	}
	
	private static void testFreeBox() {
		Pict p1 = new FreeBox("1234\n5678");
		eq(p1.toString(), "1234\n5678\n");
		
		p1.scale(1.5d);
		eq(p1.toString(), "123412\n567856\n123412\n");
	}

	private static void testDarkBox() {
		DarkBox p1 = new DarkBox(3.0d, 3.0d, 'c');
		eq(p1.toString(), "ccc\nccc\nccc\n");
		
		p1.setTheChar('*');
		
		AbstractBox p2 = p1;
		eq(p2.toString(), "***\n***\n***\n");
	}

	private static void testClearBox() {
		ClearBox p1 = new ClearBox(3.0d, 3.0d);
		eq(p1.getScale(), 1.0d);
		eq(p1.toString(), "***\n* *\n***\n");
	}

	private static void testBox() {
		Pict p1 = new Box(1, 1, '.', 'o');
		eq(p1.toString(), "o\n");
		
		p1.scale(2);
		eq(p1.toString(), "oo\noo\n");
		
		p1.scale(2);
		eq(p1.toString(), "oooo\no..o\no..o\noooo\n");
		
		Pict p2 = new Box(3.7d, 2.3d, '.', 'o');
		eq(p2.toString(), "oooo\no..o\noooo\n");
	}
	
	private static void ok(boolean cond) {
		if(cond) {
			System.out.print(".");
		} else {
			throw new RuntimeException();
		}
	}
	
	private static void eq(Object o1, Object o2) {
		if(o1.equals(o2)) {
			System.out.print(".");
		} else {
			throw new RuntimeException(String.format("\"%s\" != \"%s\"", o1, o2));
		}
	}
}
