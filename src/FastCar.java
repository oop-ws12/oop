/**
 * Stellt ein schnelles Auto dar.
 */
public class FastCar extends Car {
	/**
	 * Liefert alle erlaubten Moves.
	 * @return
	 */
	public static Move[] getValidMoves() {
		return new Move[] {
			Move.FWDLEFT,
			Move.FWD,
			Move.FWDRIGHT			
		};
	}
	
	/**
	 * @see Car
	 */
	public FastCar(Game game, MoveStrategy strategy) {
		super(game, strategy);
	}

	/**
	 * @see Car
	 */
	@Override
	protected int getSpeed() {
		return 5;
	}
}
