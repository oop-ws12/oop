
//Instanzen dieser Klasse stellen die Gesamtzeit, eines aus mehreren Einzelzeiten zusammengesetzen Prozesses dar
public class CompositeTime extends ElapsedTime {

	//Array mit den Einzelzeiten
	private Double[] times;
	//Gesamtzeit - Summer der Einzelzeiten
	private double totalTime;
	
	//Initialisiert das Objekt mit dem uebergebenen Array
	//Berechnet danach die Gesamtzeit und setzt damit die Zeit in der Superklasse ElapsedTime
	public CompositeTime(Double[] times) {
		this.times = times;
		this.getTotalTime();
		super.setTime(totalTime);
	}
	
	@Override
	public int count() {
		return times.length;
	}
	
	//Berechnet die Summer der Einzelzeiten und setzt die Gesamtzeit
	private void getTotalTime() {
		
		double sum = 0.0;
		
		for(Double d : times) {
			sum += d;
		}	
		this.totalTime = sum;
	}

}
