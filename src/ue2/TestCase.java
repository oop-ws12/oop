package ue2;

public abstract class TestCase {
	protected void group(String d) {
		System.out.println("Teste " + d);
	}

	protected void desc(String d) {
		System.out.println("  " + d);
	}

	protected void ok(boolean cond, String d) {
		System.out.print("  Test: " + d + ": ");
		if (cond) {
			System.out.println("OK");
		} else {
			System.out.println("Fehler");
			throw new RuntimeException();
		}
	}

	public abstract void test();
}
