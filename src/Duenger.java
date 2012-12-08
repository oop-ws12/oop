/**
 * Instanzen dieser Klasse stellen eine Rolle als Duengsteuer dar
 * @author Alexander Prennsberger
 */
public class Duenger extends Einsatzzweck {

	/**
	 * Die Fassungskapazitaet vom Behealter des Duengstreuers in Liter
	 */
	private double fassung;
	
	/**
	 * Initialisiert die Fassungskapaziteat des Behealters
	 * @param fassung die Fassungskapaziteat
	 * @author Alexander Prennsberger
	 */
	public Duenger(double fassung){
		this.fassung = fassung;
	}

	@Override
	public double getDaten() {
		return fassung;
	}
	
	@Override
	public boolean apply(Einsatzzweck type) {
		
		if(type.getClass().equals(Duenger.class)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return eine lesbare Form des Duengstreuers
	 * @author Alexander Prennsberger
	 */
	public String toString() {
		return "als Duengstreuer mit " + fassung + " Liter Fassungskapaziteat";
	}
}
