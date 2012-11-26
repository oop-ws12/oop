
public abstract class Bauteil {
	private String name;
	double leistungKw;
	
	/**
	 * @return Name des Bauteiles
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return Leistung des Bauteiles in kW
	 */
	public double getLeistungKw() {
		return leistungKw;
	}

	public Bauteil(String name, double leistungKw) {
		this.name = name;
		this.leistungKw = leistungKw;
	}
}
