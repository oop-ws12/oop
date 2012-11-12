public class Repeated<P> implements Pict {
	// constant after initialization
	// rectangular array
	private P[][] data;
	
	// the height
	private double height;
	
	// the width
	private double width;
	
	// the table-formated values
	private Table<P> table;

	/**
	 * @param data
	 */
	public Repeated(P[][] data) {
		this.data = data;
		
		this.width = data[0].length;
		this.height = data.length;
		
		table = new Table<P>(this.data);
	}
	
	// returns the picture as String
	@Override
	public String toString() {
		int w = (int)Math.ceil(width);
		int h = (int)Math.ceil(height);
		
		return table.renderTable(w, h);
	}

	// 0.1 <= factor <= 10.0; resize the picture
	@Override
	public void scale(double factor) {
		height *= factor;
		width *= factor;
	}
}
