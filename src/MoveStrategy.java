
public abstract class MoveStrategy {
	public static class Random extends MoveStrategy {
		private Move[] moves;
		private java.util.Random r;
		
		public Random(Move[] moves) {
			this.moves = moves;
			this.r = new java.util.Random();
		}

		@Override
		public Move getNextMove() {
			return moves[r.nextInt(moves.length)];
		}
	}
	
	public static class Always extends MoveStrategy {
		private Move move;
		
		public Always(Move move) {
			this.move = move;
		}

		@Override
		public Move getNextMove() {
			return move;
		}
	}
	
	public abstract Move getNextMove();
}
