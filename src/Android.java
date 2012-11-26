/**
 * Ein Android
 */
public abstract class Android {
	private static int serialNr = 0;
	private static String generateSerial() {
		serialNr++;
		return "SN" + serialNr;
	}
	
	/**
	 * Die Seriennummer.
	 */
	private String serial;

	/**
	 * @return Die Seriennummer
	 */
	public String getSerial() {
		return serial;
	}

	public Android() {
		this.serial = generateSerial();
	}
	
	/**
	 * Liefert den Namen und Seriennummer des Androiden.
	 */
	@Override
	public String toString() {
		return String.format("%s(%s)", getClass().getName(), getSerial());
	}
	
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
