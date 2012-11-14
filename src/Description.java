/**
 * Stellt einen beschreibenden Text 
 */
public class Description implements Shorter<Description> {
	private String desc;

	/**
	 * @param desc
	 */
	public Description(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return desc;
	}
	
	@Override
	public boolean shorter(Description other) {
		return toString().length() < other.toString().length();
	}
	
	/**
	 * Gibt die Anzahl der Zeilen zurueck.
	 * @return
	 */
	public int lineCount() {
		return desc.split("\n").length;
	}
}
