/**
 * Stellt ein bewegliches Auto dar.
 */
public class MoveCar extends Car {
	/**
	 * @see Car
	 */
	public MoveCar(Game game, MoveStrategy strategy) {
		super(game, strategy);	
	}
	
	/**
	 * Liefert alle erlaubten Bewegungen des Autos.
	 * @return
	 */
	public static Move[] getValidMoves() {
		return new Move[] {
			Move.FWDLEFT,
			Move.FWD,
			Move.FWDRIGHT,
			Move.LEFT,
			Move.RIGHT
		};
	}
	
	/**
	 * Der Speed des Autos.
	 */
	@Override
	protected int getSpeed() {
		return 70;
	}

}
