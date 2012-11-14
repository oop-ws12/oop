import java.util.Iterator;

//instances of this class represent the average time of a measurement series
public class MeanElapsedTime extends ElapsedTime {

	//set with the particular measured times of the series
	private Set<Double> data;
	
	//the average time of the series
	private double average;
	
	//initializes the MeanElapsedTime with the given set of measured data
	//data != null
	public MeanElapsedTime(Set<Double> data) {
		this.data = data;
	}
	
	/**
	 * adds a value to the measurement series
	 * @param value != null
	 * @return true if the set was changend as a result of the method call
	 */
	public boolean addMeasuredValue(Double value) {
		return data.insert(value);
	}
	
	/**
	 * @return the biggest value of the set
	 */
	public Double highestValue() {
		return null;
	}
	
	@Override
	public int count() {
		
		int number = 0;
		Iterator<Double> it = data.iterator();
		
		while(it.hasNext()) {
			number++;
			it.next();
		}
		return number;
	}
	
	public boolean shorter(MeanElapsedTime other) {
		return false;
	}
}
