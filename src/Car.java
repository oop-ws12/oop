/**
 * Stellt ein Auto dar.
 */
public abstract class Car implements Runnable {
	/**
	 * Das zugehoerige Spiel
	 */
	private Game game;

	/**
	 * Die aktuelle Position
	 */
	private Point position;

	/**
	 * Die aktuele Richtung (Winkel) des Autos. Invariante: Es muss gelten angle
	 * % 90 == 0.
	 */
	private int angle;

	/**
	 * Eine Bewegungsstrategie
	 */
	private MoveStrategy strategy;

	/**
	 * Die aktuelle Punkteanzahl
	 */
	private int points;
	private int feldwechsel;

	/**
	 * @return Die aktuelle Punkteanzahl
	 */
	public int getPoints() {
		return points;
	}

	public int getFeldwechsel() {
		return feldwechsel;
	}

	/**
	 * @return Die aktuele Richtung (Winkel) des Autos.
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * Setzt sie aktuele Richtung (Winkel) des Autos.
	 * 
	 * @param Vorbed
	 *            : angle % 90 == 0
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/**
	 * @param position
	 *            Setzt die Position des Autos.
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * @return die Position des Autos im Spielfeld.
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * @return das zugehoerige Game.
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Erzeugt eine Car Instanz.
	 * 
	 * @param game
	 *            das zugehoerige Spiel(-brett)
	 * @param strategy
	 *            eine Bewegungsstrategie
	 */
	public Car(Game game, MoveStrategy strategy) {
		this.game = game;
		this.strategy = strategy;
		this.points = 0;

		game.add(this);
	}

	/**
	 * Startet das Auto.
	 */
	@Override
	public void run() {		
		while (!Thread.currentThread().isInterrupted()) {
			drive();
			pause();
		}
	}

	/**
	 * Pausiert das Auto bzw. den Thread (nach getSpeed()).
	 * 
	 * @throws InterruptedException
	 */
	protected void pause() {
		try {
			Thread.sleep(getSpeed());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Liefert die Geschwindigkeit des Autos.
	 */
	protected abstract int getSpeed();

	/**
	 * Bewegt das Auto einen Move vorwaerts.
	 */
	protected void drive() {
		feldwechsel++;
		game.drive(this, strategy.getNextMove());
	}

	/**
	 * Addiert Punkte.
	 * 
	 * @param points
	 *            die Punkte
	 */
	public void addPoints(int points) {
		this.points += points;
	}

	/**
	 * Liefert eine Beschreibung des Autos.
	 */
	@Override
	public String toString() {
		return String.format("Car(pos=(%d, %d), points=%d)",
				position.getX(), position.getY(), points);
	}
}
