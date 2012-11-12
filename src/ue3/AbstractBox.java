// represents a boxed image
public abstract class AbstractBox implements Pict {	
	// the height of the picture
	private double width;
		
	// the width of the picture
	private double height;
	

	/**
	 * @return the width
	 */
	protected double getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	protected double getHeight() {
		return height;
	}

	/**
	 * @return the innerChar
	 */
	protected abstract char getInnerChar();


	/**
	 * @return the borderChar
	 */
	protected abstract char getBorderChar();

	/**
	 * initializes the AbstractBox with the given width and height
	 * @param width != null
	 * @param height != null
	 */
	protected AbstractBox(double width, double height) {
		this.width = width;
		this.height = height;
	}
	

	// 0.1 <= factor <= 10.0; resize the picture
	@Override
	public void scale(double factor) {
		width *= factor;
		height *= factor;
	}

	// returns the picture as String
	@Override
	public String toString() {
		int w = (int)Math.ceil(getWidth());
		int h = (int)Math.ceil(getHeight());
		StringBuilder r = new StringBuilder();
		
		for(int y = 0; y < h; y++) {
			line(r, w, y == 0 || y == h-1);
		}
		
		return r.toString();
	}
	
	// appends a line to the stringbuilder
	private void line(StringBuilder r, int w, boolean border) {
		for(int x = 0; x < w; x++) {
			if(border || x == 0 || x == w-1) {
				r.append(getBorderChar());
			} else {
				r.append(getInnerChar());
			}
		}
		r.append('\n');
	}
}
