// box, innerChar is always equal to outerChar
public class DarkBox extends AbstractBox {
	// the character for border and contents
	private char theChar;
	
	@Override
	protected char getInnerChar() {
		return theChar;
	}
	
	@Override
	protected char getBorderChar() {
		return theChar;
	}
	
	//initializes the DarkBox
	//innerChar == outerChar
	public DarkBox(double width, double height, char theChar) {
		super(width, height);
		this.theChar = theChar;
	}

	/**
	 * @param theChar sets the character for border and contents
	 * theChar != ' '
	 */
	public void setTheChar(char theChar) {
		assert theChar != ' ';
		this.theChar = theChar;
	}
}
