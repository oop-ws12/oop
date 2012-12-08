/**
 * Instanzen dieser Klasse stellen eine Rolle als Drillmaschine dar
 * @author Alexander Prennsberger
 */
public class Driller extends Einsatzzweck {

	/*
	 * Die Anzahl der Saeschare der Drillmaschine
	 */
	private int saschare;

	/**
	 * Initialsiert die Drillmaschine mit der uebergebenen Anzahl an Saescharen
	 * @param saschare Anzahl der Saeschare
	 * @author Alexander Prennsberger
	 */
	public Driller(int saschare) {
		this.saschare = saschare;
	}

	@Override
	public double getDaten() {
		return (double) saschare;
	}
	
	@Override
	public boolean apply(Einsatzzweck type) {
	
		if(type.getClass().equals(Driller.class)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @retrun eine lesbare Form der Drillmaschine
	 * @author Alexander Prennsberger
	 */
	public String toString() {
		return "als Drillmaschine mit " + saschare + " Saescharen";
	}	
}
