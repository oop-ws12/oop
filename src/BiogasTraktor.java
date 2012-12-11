
/**
 * Instanzen dieser Klasse stellen einen Traktor mit Biogasmotor dar
 */
@Author("Lukas Steinbrecher")
public class BiogasTraktor extends Traktor {

	/**
	 * Gibt an wie viel Kubikmeter Gas der Traktor seit
	 * Betriebsbeginn verbraucht hat
	 */
	private double gasVerbrauch = 0;
	
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
		
		return type.getClass().equals(BiogasTraktor.class);

	}
	
	/**
	 * @return eine lesbare Form des BiogasTraktors
	 */
	@Author("Lukas Steinbrecher")
	public String toString() {
		return super.toString() + "Biogasverbrauch seit Betriebsbeginn: " + gasVerbrauch + " Kubikmeter \n";
	}

}
