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
	 * Diese Klasse wird benoetigt sonst schafft es der arme
	 * Java-Compiler nicht ein List array zu erstellen.
	 */
	private class CarList extends ArrayList<Car> {
		private static final long serialVersionUID = 6089283717839076193L;
	}
	
	private Map<Car, Thread> threads;
	private CarList[][] table;
	
	private int height;
	private int width;
	
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
		add(car, new Point(r.nextInt(height), r.nextInt(width)));
	}
	
	private int norm(int i, int max) {
		while(i < 0) i += max;
		return i % max;
	}
	
	/**
	 * Fuegt ein Car an einer bestimmten Position zum Spiel hinzu, 
	 * falls es noch nicht im Spiel exisitiert.
	 */
	private void add(Car car, Point position) {
		threads.put(car, new Thread(car));
		
		CarList field = table[norm(position.getX(), height)][norm(position.getY(), width)];
		if(field == null) {
			field = table[norm(position.getX(), height)][norm(position.getY(), width)] = new CarList();
		} else if(field.size() > 0) {
			collision(car, field);
		}
		
		field.add(car);
		car.setPosition(position);
	}
	
	public void start() {
		for(Thread t : threads.values()) {
			t.start();
		}
	}
	
	private void remove(Car car) {
		CarList field = table[norm(car.getPosition().getX(), height)][norm(car.getPosition().getY(), width)];
		if(field != null) {
			field.remove(car);
			if(field.size() == 0)
				table[norm(car.getPosition().getX(), height)][norm(car.getPosition().getY(), width)] = null;
		}
	}
	
	private void collision(Car car, Collection<Car> with) {
		for(Car w : with) {
			if((180 + w.getAngle())%360 == car.getAngle()) {
				System.out.println("Collision +1");
				car.addPoints(1);
			} else {
				System.out.println("Collision -1");
				w.addPoints(-1);
			}
		}
		
		if(car.getPoints() > 2) {
			finish();
		}
	}
	
	private void finish() {
		System.out.println("ich bin in finish");
		for(Thread t : threads.values()) {
			t.interrupt();
		}
	}

	public synchronized void drive(Car car, Move move) {
		
		if(car.getFeldwechsel() > 2) {
			finish();
		}
		Point delta = move.getPositionDelta(car.getAngle());
		
		remove(car);
		car.setAngle(move.getNewAngle(car.getAngle()));	
		add(car, Point.add(car.getPosition(), delta));
		
		// DEBUG
		System.out.println(toString());
	}
	
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
