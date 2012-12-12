/**
 * Dieses Interafce beschreibt die Methoden getDaten() und toString()
 * Ueber die Methode getDaten() werden die spezifischen Daten der jeweilgen
 * Rollen ausgelesen
 * Ein Einsatzzweck stellt eine Rolle des Traktors dar
 */
@Author("Lukas Steinbrecher")
interface Einsatzzweck extends Filter {
	
	/**
	 * Ueber diese Mehtode wird einheitlich auf die Daten der einzelnen
	 * Einsatzzwecke zugegriffen
	 * @return Einsatzzweck spezifische Daten
	 */
	@Author("Lukas Steinbrecher")
	double getDaten();
	
	/**
	 * @return eine lesbare Form des Einsatzzwecks
	 */
	@Author("Lukas Steinbrecher")
	String toString();
}
