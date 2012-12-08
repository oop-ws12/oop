/**
 * Das Interface berschreibt eine Mehtode getDaten(), 
 * welche die Daten einer bestimmeten Rolle eines Traktors liefert
 * @author Alexander Prennsberger
 */
public abstract class Einsatzzweck implements Filter {
	
	/**
	 * Ueber diese Mehtode wird einheitlich auf die Daten der einzelnen
	 * Einsatzzwecke zugegriffen
	 * @return Einsatzzweck spezifische Daten
	 * @author Alexander Prennsberger
	 */
	public abstract double getDaten();
}
