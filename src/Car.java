/**
 * Stellt ein Auto dar.
 */
public abstract class Car implements Runnable {
	private Game game;
	private Point position;
	private int angle;
	private MoveStrategy strategy;
	private int points;

	public int getPoints() {
		return points;
	}

	/**
	 * @return the angle
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * @param angle
	 *            the angle to set
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

	public Game getGame() {
		return game;
	}

	public Car(Game game, MoveStrategy strategy) {
		this.game = game;
		this.strategy = strategy;
		this.points = 0;

		game.add(this);
	}

	@Override
	public void run() {
		try {
			for (;;) {
				drive();
				pause();
			}
		} catch (InterruptedException e) {
			System.out.println(toString());
		}
	}

	protected void pause() throws InterruptedException {
		Thread.sleep(getSpeed());
	}

	/**
	 * Gets the speed in Moves/sec.
	 */
	protected abstract int getSpeed();

	protected void drive() {
		game.drive(this, strategy.getNextMove());
	}

	public synchronized void addPoints(int i) {
		points += i;
	}
	
	@Override
	public String toString() {
		return String.format("Car(pos=(%d, %d), angle=%d, points=%d)", position.getX(), position.getY(), angle, points);
	}
}
