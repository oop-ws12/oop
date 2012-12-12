/**
 * Instanzen dieser Klasse stellen eine Rolle als Drillmaschine dar
 */
@Author("Lukas Steinbrecher")
class Driller implements Einsatzzweck {

	/*
	 * Die Anzahl der Saeschare der Drillmaschine
	 */
	private int saschare;

	/**
	 * Initialsiert die Drillmaschine mit der uebergebenen Anzahl an Saescharen
	 * @param saschare Anzahl der Saeschare
	 */
	@Author("Lukas Steinbrecher")
	public Driller(int saschare) {
		this.saschare = saschare;
	}
	
	public double getDaten() {
		return saschare;
	}
	
	public boolean apply(Object type) {
		
		return type.getClass().equals(Driller.class);
	}
	
	/**
	 * @retrun eine lesbare Form der Drillmaschine
	 */
	@Author("Lukas Steinbrecher")
	public String toString() {
		return "als Drillmaschine mit " + saschare + " Saescharen";
	}	
}
