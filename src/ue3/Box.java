// represents a boxed image
public class Box extends AbstractBox {
	// the char which is used for the inner content of the box
	// constant after initialization
	private char innerChar;
	
	// the char which is used for the border of the box
	// constant after initialization
	// borderChar != ' '
	private char borderChar;
	

	/**
	 * @return the innerChar
	 */
	@Override
	protected char getInnerChar() {
		return innerChar;
	}


	/**
	 * @return the outerChar
	 */
	@Override
	protected char getBorderChar() {
		return borderChar;
	}


	/**
	 * @param width
	 * @param height
	 * @param innerChar
	 * @param borderChar != ' '
	 */
	public Box(double width, double height, char innerChar, char borderChar) {
		super(width, height);
		
		assert borderChar != ' ';
		this.innerChar = innerChar;
		this.borderChar = borderChar;
	}
}
