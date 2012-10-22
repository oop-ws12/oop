package ue2;

public abstract class AbstractTest {
	protected void desc(String d) {
		System.out.println("  " + d);
	}

	/**
	 * Startet den Test.
	 */
	public abstract void start();
}
