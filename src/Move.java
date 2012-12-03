/**
 * Stellt eine Bewegung eines Autos dar.
 */
public enum Move {
	FWD(0),
	FWDLEFT(45),
	FWDRIGHT(315),
	LEFT(90),
	RIGHT(270);
	
	/**
	 * In Grad.
	 */
	private int angle;
	
	/**
	 * Erzeugt eine Bewegung in eine Bestimmte Richtung.
	 * @param angle in grad
	 */
	Move(int angle) {
		this.angle = angle;
	}
	
	/**
	 * Liefert die Positionsaenderung (also die x bzw. y Einheiten) 
	 * zu einen bestimmten alten Winkel.
	 * @param oldAngle der alte Winkel
	 * @return die Positionsaenderung (max. -1 bis 1 in jede Richtung)
	 */
	Point getPositionDelta(int oldAngle) {
		int newAngle = getNewAngle(oldAngle);
		
		int positionDeltaX = 0, positionDeltaY = 0;
		
		if(newAngle != 90 && newAngle != 270) {
			positionDeltaX = newAngle > 90 && newAngle < 270 ? -1 : 1;
		}
		
		if(newAngle != 0 && newAngle != 180) {
			positionDeltaY = newAngle > 0 && newAngle < 180 ? -1 : 1;
		}
		
		return new Point(positionDeltaX, positionDeltaY);
	}
	
	/**
	 * Liefert den neuen Winkel.
	 * @param oldAngle der alte Winkel
	 * @return den neuen Winkel in Grad
	 */
	int getNewAngle(int oldAngle) {
		return (this.angle + oldAngle) % 360;
	}
}
