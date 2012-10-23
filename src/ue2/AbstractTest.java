package ue2;

/**
 * Ein Test.
 * 
 */
public abstract class AbstractTest {
	protected void desc(String d) {
		System.out.println("  " + d);
	}

	/**
	 * Startet den Test.
	 */
	public abstract void start();
}
