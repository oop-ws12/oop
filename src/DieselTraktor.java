
/**
 * Instanzen dieser Klasse Stellen einen Traktor mit Dieselmotor dar
 * @author Alexander Prennsberger
 */
public class DieselTraktor extends Traktor {

	/**
	 * Gibt an, wie viel Liter Diesel der Traktor seit
	 * Betriebsbeginn verbraucht hat
	 */
	private int dieselVerbrauch;
		
	
	@Override
	protected void setSpritVerbrauch(double diesel) {
		this.dieselVerbrauch += (int)diesel;
	}
	
	@Override
	protected double getSpritVerbrauch() {
		return (double) dieselVerbrauch;
	}
	
	@Override
	public boolean apply(Object type) {
		
		if(type.getClass().equals(DieselTraktor.class)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return eine lesbare Form des DieselTraktors
	 * @author Alexander Prennsberger
	 */
	public String toString() {
		return super.toString() + "Dieselverbrauch seit Betriebsbeginn: " + dieselVerbrauch + " Liter \n";
	}
}
