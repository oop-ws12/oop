
//Instanzen dieser Klasse stellen die gemessene Zeit eines Vorgangs dar
public abstract class ElapsedTime implements Shorter<ElapsedTime> {

	//die gemessene Zeit in Millisekunden
	private double time;
	
	/**
	 * berechnet die Anzahl der Messungen
	 * @return die Anzahl der Messungen
	 */
	 abstract public int count();
	 
	 /**
	  * Setzt die gemessene Zeit
	  * @param time, Zeit die gesetzt wird
	  */
	 public void setTime(double time) {
		 this.time = time;
	 }
	 
	 @Override
	 public boolean shorter(ElapsedTime other) {	 
		 return this.time < other.time;
	 }	
}
