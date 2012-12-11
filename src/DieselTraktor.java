
/**
 * Instanzen dieser Klasse Stellen einen Traktor mit Dieselmotor dar
 */
@Author("Lukas Steinbrecher")
public class DieselTraktor extends Traktor {

	/**
	 * Gibt an, wie viel Liter Diesel der Traktor seit
	 * Betriebsbeginn verbraucht hat
	 */
	private int dieselVerbrauch = 0;
		
	
	@Override
	protected void setSpritVerbrauch(double diesel) {
		this.dieselVerbrauch += (int)diesel;
	}
	
	@Override
	protected double getSpritVerbrauch() {
		return dieselVerbrauch;
	}
	
	@Override
	public boolean apply(Object type) {
		
		return type.getClass().equals(DieselTraktor.class);
	
	}
	
	/**
	 * @return eine lesbare Form des DieselTraktors
	 */
	@Author("Lukas Steinbrecher")
	public String toString() {
		return super.toString() + "Dieselverbrauch seit Betriebsbeginn: " + dieselVerbrauch + " Liter \n";
	}
}
