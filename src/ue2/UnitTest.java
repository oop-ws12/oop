
/**
 * Testet eine Einheit.
 */
public abstract class UnitTest extends AbstractTest {
	
	/**
	 * Prueft die uebergebene Bedingung 
	 * Liefert einen "Punkt" als lesbare Ausgabe falls true
	 * Gibt "Fehler" aus und wirft RuntimeException sonst
	 * @param cond Bedingung
	 */
	protected void ok(boolean cond) {
		if (cond) {
			System.out.print(".");
		} else {
			System.out.println("Fehler");
			throw new RuntimeException();
		}
	}
	
	/**
	 * Ueberladene Methode mit zusaetzlicher Beschreibung, was geprueft wird
	 * @param cond Bedingung	
	 * @param text 
	 */
	protected void ok(boolean cond, String text) {
		ok(cond);
	}
}
