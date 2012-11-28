/**
 * Stellt einen Senor dar.
 */
public class Sensor extends Bauteil {
	public Sensor(String name) {
		super(name, 0);
	}
	
	@Override
	public String toString() {
		return String.format("Sensor (%s)", getName());
	}
}
