// a box, innerChar is always ' ' outerChar is always '*'
public class ClearBox extends Box {
	public ClearBox(double width, double height) {
		super(width, height, ' ', '*');
	}

	// returns the scale
	public double getScale() {
		return getWidth() / getHeight();
	}
}
