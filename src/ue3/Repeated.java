
public class Repeated<P> implements Pict {
	// constant after initialization
	// rectangular array
	private P[][] data;
	
	// the height
	private double height;
	
	// the width
	private double width;

	/**
	 * @param data
	 */
	public Repeated(P[][] data) {
		this.data = data;
		
		this.width = data[0].length;
		this.height = data.length;
	}
	
	
	// returns the picture as String
	@Override
	public String toString() {
		return "";
	}

	// 0.1 <= factor <= 10.0; resize the picture
	@Override
	public void scale(double factor) {
		height *= factor;
		width *= factor;
	}
}
