/**
 * Instanzen dieser Klasse stellen eine Rolle als Duengsteuer dar
 */
@Author("Lukas Steinbrecher")
class Duenger implements Einsatzzweck {

	/**
	 * Die Fassungskapazitaet vom Behealter des Duengstreuers in Liter
	 */
	private double fassung;
	
	/**
	 * Initialisiert die Fassungskapaziteat des Behealters
	 * @param fassung die Fassungskapaziteat
	 */
	@Author("Lukas Steinbrecher")
	public Duenger(double fassung){
		this.fassung = fassung;
	}

	public double getDaten() {
		return fassung;
	}
	
	public boolean apply(Object type) {
		
		return type.getClass().equals(Duenger.class);
		
	}
	
	/**
	 * @return eine lesbare Form des Duengstreuers
	 */
	@Author("Lukas Steinbrecher")
	public String toString() {
		return "als Duengstreuer mit " + fassung + " Liter Fassungskapaziteat";
	}
}
