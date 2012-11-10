
public class FreeBox implements Pict {
	// rectangular text
	private String[] lines;
	
	// width of the image
	private double width;
	
	// height of the image
	private double height;
	
	protected FreeBox(String text) {
		this(text.split("\n"));
	}
	
	private FreeBox(String[] lines) {
		this.width = lines[0].length();
		this.height = lines.length;
		this.lines = lines;
	}

	// 0.1 <= factor <= 10.0; resize the picture
	@Override
	public void scale(double factor) {
		width *= factor;
		height *= factor;
	}

	@Override
	public String toString() {
		int h = (int)Math.ceil(height);
		int w = (int)Math.ceil(width);
		
		StringBuilder o = new StringBuilder();
		
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				String line = lines[y % lines.length];
				o.append(line.charAt(x % line.length()));
			}
			
			o.append('\n');
		}
		
		return o.toString();
	}
}
