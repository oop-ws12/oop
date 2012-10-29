
/**
 * Stellt die Basisklasse aller Tests dar
 * 
 */
public abstract class AbstractTest {
	
	/**
	 * Erstellt eine lesbare Ausgabe einer Beschreibung
	 * @param d Beschreibung
	 */
	protected void desc(String d) {
		System.out.println("  " + d);
	}

	/**
	 * Startet den Test
	 */
	public abstract void start();
}
