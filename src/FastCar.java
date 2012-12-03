
public class FastCar extends Car {
	public static Move[] getValidMoves() {
		return new Move[] {
			Move.FWDLEFT,
			Move.FWD,
			Move.FWDRIGHT			
		};
	}
	
	public FastCar(Game game, MoveStrategy strategy) {
		super(game, strategy);
	}

	@Override
	protected int getSpeed() {
		return 100;
	}
}
