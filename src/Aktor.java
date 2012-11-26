
public class Aktor extends Bauteil {
	public Aktor(String name, double leistungKw) {
		super(name, leistungKw);
	}
	
	@Override
	public String toString() {
		return String.format("Aktor (%s) %2d kW", getName(), getLeistungKw());
	}
}
