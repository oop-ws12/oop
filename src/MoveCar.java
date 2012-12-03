
public class MoveCar extends Car {
	public MoveCar(Game game, MoveStrategy strategy) {
		super(game, strategy);	
	}
	
	public static Move[] getValidMoves() {
		return new Move[] {
			Move.FWDLEFT,
			Move.FWD,
			Move.FWDRIGHT,
			Move.LEFT,
			Move.RIGHT
		};
	}
	
	@Override
	protected int getSpeed() {
		return 70;
	}

}
