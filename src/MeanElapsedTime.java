
//Instanzen dieser Klasse stellen die durchschnittliche Zeit einer Messreihe dar
public class MeanElapsedTime extends ElapsedTime {

	//Set mit den einzelnen Messwerten der Reihe
	private Set<Double> data;
	
	//die durchschnittliche Zeit der Reihe
	private double average;
	
	//Initialisiert das Objekt mit dem uebergebenen Set
	//Berechnet danach die durschnittliche Zeit der Reihe und setzt damit die Zeit in der
	//Superklasse ElapsedTime
	//data != null
	public MeanElapsedTime(Set<Double> data) {
		this.data = data;
		this.getAverage();
		super.setTime(average);
	}
	
	/**
	 * Fuegt der Reihe einen neuen Messwert hinzu
	 * berechnet nach dem Hinzufuegen die durchschnittliche Zeit neu
	 * @param value != null
	 * @return true, wenn das Set nach Methodenaufruf veraendert wurde
	 */
	public boolean addMeasuredValue(Double value) {
		
		if(data.insert(value) == true) {
			this.getAverage();
			return true;
		}
		return false;
	}
	
	/**
	 * @return den groessten Messwert im Set
	 */
	public double highestValue() {
		
		double current = 0.0;
		
		for(Double d : data) {
			if(d > current) {
				current = d;
			}	
		}
		
		return current;
	}
	
	@Override
	public int count() {
		return data.count();
	}
	
	/*
	 * Berechnet die durschnittliche Zeit der Messreihe 
	 * und setzt sie anschliessend
	 */
	private void getAverage() {
		
		double sum = 0;
		
		for(Double d : data) {	
			sum += d;
		}
		this.average = sum/this.count();	
	}
}
