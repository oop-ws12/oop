import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Stellt ein Spiel dar.
 */
public class Game {
	/**
	 * Benoetigt um Compiler-Warnung zu umgehen (fuer das Array)
	 */
	private class CarList extends ArrayList<Car> {
		private static final long serialVersionUID = 6089283717839076193L;
	}
	
	/**
	 * Thread Map
	 */
	private Map<Car, Thread> threads;
	
	/**
	 * Das Spielfeld
	 */
	private CarList[][] table;
	
	/**
	 * Hoehe des Spielfeldes
	 */
	private int height;
	
	/**
	 * Breite des Spielfeldes
	 */
	private int width;
	
	/**
	 * Erzeugt eine Game Instanz.
	 * @param height hoehe > 0
	 * @param width breite > 0
	 */
	public Game(int height, int width) {
		this.table = new CarList[width][height];
		this.threads = new HashMap<Car, Thread>();
		this.height = width;
		this.width = height;
	}
	
	/**
	 * Fuegt ein Car an einer zufaelligen Position zum Spiel hinzu.
	 */
	public void add(Car car) {
		Random r = new Random();
		move(car, new Point(r.nextInt(height), r.nextInt(width)));
		threads.put(car, new Thread(car));
	}
	
	/**
	 * Normiert eine Array-Index position - Helper Methode.
	 * @param i index
	 * @param max max-index
	 * @return den normierten Index.
	 */
	private int norm(int i, int max) {
		while(i < 0) i += max;
		return i % max;
	}
	
	/**
	 * Fuegt ein Car an einer bestimmten Position zum Spiel hinzu, 
	 * falls es noch nicht im Spiel exisitiert.
	 */
	private void move(Car car, Point position) {		
		CarList field = table[norm(position.getX(), height)][norm(position.getY(), width)];
		if(field == null) {
			field = table[norm(position.getX(), height)][norm(position.getY(), width)] = new CarList();
		} else if(field.size() > 0) {
			collision(car, field);
		}
		
		field.add(car);
		car.setPosition(position);
		
		if(car.getPoints() > 10) {
			finish(car, true);
		} else if(car.getFeldwechsel() > 100) {
			finish(car, false);
		}
	}
	
	/**
	 * Startet die Simulation.
	 */
	public void start() {
		for(Thread t : threads.values()) {
			t.start();
		}
	}
	
	/**
	 * Wartet solange bis das Spiel vorbei ist.
	 */
	public void waitForFinish() {
		for(Thread t : threads.values()) {
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		}
	}
	
	/**
	 * Entfernt ein Car vom Spielfeld.
	 * @param car
	 */
	private void remove(Car car) {
		CarList field = table[norm(car.getPosition().getX(), height)][norm(car.getPosition().getY(), width)];
		if(field != null) {
			field.remove(car);
			if(field.size() == 0)
				table[norm(car.getPosition().getX(), height)][norm(car.getPosition().getY(), width)] = null;
		}
	}
	
	/**
	 * Diese Methode wird bei einer Methode aufgerufen.
	 * Verteilt die Punkte nach den Spielregeln.
	 * 
	 * @param car das kollidierende Auto
	 * @param with Autos mit denen kolidiert wird
	 */
	private void collision(Car car, Collection<Car> with) {
		for(Car w : with) {
			if((180 + w.getAngle())%360 == car.getAngle()) {
				car.addPoints(1);
			} else {
				w.addPoints(-1);
			}
		}
	}

	
	/**
	 * Beendet das Spiel.
	 * @param winner Winner-Car oder null falls kein gewinner.
	 */
	private void finish(Car winner, boolean isWinner) {
		if(isWinner)
			System.out.println("Sieger nach Punktezahl: " + winner);
		else
			System.out.println("Ende: Max Feldwechsel bei " + winner);
		
		for(Car c : threads.keySet()) {
			threads.get(c).interrupt();
		}
	}

	/**
	 * Bewegt ein Auto.
	 * @param car das Auto
	 * @param move ein erlaubter Move
	 */
	public synchronized void drive(Car car, Move move) {
		Point delta = move.getPositionDelta(car.getAngle());
		
		remove(car);
		car.setAngle(move.getNewAngle(car.getAngle()));	
		move(car, Point.add(car.getPosition(), delta));
	}
	
	/**
	 * Gibt das Spielfeld mit den Autos aus.
	 */
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		
		for(CarList[] lines : table) {
			for(CarList fields : lines) {
				if(fields != null && fields.size() > 0) {
					b.append(fields.size());
				} else {
					b.append(".");
				}
			}
			
			b.append("\n");
		}
		
		return b.toString();
	}
}