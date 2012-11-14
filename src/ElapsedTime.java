
//instances of this class represent the measured time from a process
public abstract class ElapsedTime implements Shorter<ElapsedTime> {

	//measured time in milliseconds
	private double time;
	
	/**
	 * calculates the number of executed measures
	 * @return the number of measures
	 */
	 abstract public int count();
	 
	 public boolean shorter(ElapsedTime other) {	 
		 return this.time < other.time;
	 }	
}
