/**
 * Stellt eine Bewegung eines Autos dar.
 */
public enum Move {
	FWD(0),
	FWDLEFT(45),
	FWDRIGHT(315),
	LEFT(90),
	RIGHT(270);
	
	private int angle;
	Move(int angle) {
		this.angle = angle;
	}
	
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
	
	int getNewAngle(int oldAngle) {
		return (this.angle + oldAngle) % 360;
	}
}
