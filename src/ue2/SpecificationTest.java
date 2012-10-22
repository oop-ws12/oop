package ue2;

public abstract class SpecificationTest extends AbstractTest {
	protected abstract String getSpecification();

	protected void ok(boolean cond, String d) {
		System.out.print("  Test: " + d + ": ");
		if (cond) {
			System.out.println("OK");
		} else {
			System.out.println("Fehler");
			throw new RuntimeException();
		}
	}

	@Override
	public void start() {
		System.out.println("Spezifikation: " + getSpecification());
		test();
	}

	public abstract void test();
}
