
/**
 * Testet eine Einheit.
 */
public abstract class UnitTest extends AbstractTest {
	protected void ok(boolean cond) {
		if (cond) {
			System.out.print(".");
		} else {
			System.out.println("Fehler");
			throw new RuntimeException();
		}
	}

	protected void ok(boolean cond, String text) {
		ok(cond);
	}
}
