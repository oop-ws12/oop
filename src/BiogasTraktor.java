
/**
 * Instanzen dieser Klasse stellen einen Traktor mit Biogasmotor dar
 * @author Alexander Prennsberger
 */
public class BiogasTraktor extends Traktor {

	/**
	 * Gibt an wie viel Kubikmeter Gas der Traktor seit
	 * Betriebsbeginn verbraucht hat
	 */
	private double gasVerbrauch;
	
	@Override
	protected void setSpritVerbrauch(double gas) {
		this.gasVerbrauch += gas;
	}

	@Override
	protected double getSpritVerbrauch() {
		return gasVerbrauch;
	}
	
	@Override
	public boolean apply(Object type) {
		
		if(type.getClass().equals(BiogasTraktor.class)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return eine lesbare Form des BiogasTraktors
	 * @author Alexander Prennsberger
	 */
	public String toString() {
		return super.toString() + "Biogasverbrauch seit Betriebsbeginn: " + gasVerbrauch + " Kubikmeter \n";
	}

}
