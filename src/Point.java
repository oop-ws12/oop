/**
 * Stellt einen Punkt dar.
 */
public class Point {
	/**
	 * Addiert zwei Punkte.
	 * @param p1
	 * @param p2
	 * @return den addierten Punkt
	 */
	public static Point add(Point p1, Point p2) {
		return new Point(p1.getX() + p2.getX(), p1.getY() + p2.getY());
	}
	
	/**
	 * X-Koordinate
	 */
	private final int x;
	private final int y;
	
	/**
	 * @return x Koordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return y Koordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Erstellt eine Point Insatnz.
	 * @param x Koordinate
	 * @param y Koordinate
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	/**
	 * Liefert die Koordinaten als String.
	 */
	@Override
	public String toString() {
		return String.format("Point(%d, %d)", x, y);
	}
}
