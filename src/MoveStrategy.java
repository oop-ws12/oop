/**
 * Stellt eine Bewegungsstrategie dar.
 */
public abstract class MoveStrategy {
	/**
	 * Zufaellige Bewegungen.
	 */
	public static class Random extends MoveStrategy {
		/**
		 * Aus diesen Moves wird ein zufaelliger ausgewaehlt.
		 */
		private Move[] moves;
		
		/**
		 * Ein (Pseoudo-)Zufallswertgenerator.
		 */
		private java.util.Random r;
		
		/**
		 * Erzeugt eine Random Instanz.
		 * @param moves aus diesen Moves wird ein zufaelliger ausgewaehlt
		 */
		public Random(Move[] moves) {
			this.moves = moves;
			this.r = new java.util.Random();
		}

		/**
		 * @see MoveStrategy
		 */
		@Override
		public Move getNextMove() {
			return moves[r.nextInt(moves.length)];
		}
	}
	
	/**
	 * Immer in die gleiche Richtung.
	 * z.B. new Always(Move.LEFT) fuer eine Kreisbewegung.
	 */
	public static class Always extends MoveStrategy {
		/**
		 * Der move.
		 */
		private Move move;
		
		/**
		 * Erzeugt eine Always Instanz.
		 * @param move
		 */
		public Always(Move move) {
			this.move = move;
		}
		
		/**
		 * @see MoveStrategy
		 */
		@Override
		public Move getNextMove() {
			return move;
		}
	}
	
	/**
	 * Liefert den naechsten Move nach der Strategie.
	 * @return den naechsten Move.
	 */
	public abstract Move getNextMove();
}
