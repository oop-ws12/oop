// kein untertyp von Repeated<P> da sich scale anderst verhaelt.
public class Scaled<P extends Pict> implements Pict {
	// constant after initialization
	// rectangular array
	private P[][] data;
	
	/**
	 * initializes the array with the given data
	 * @param data != null
	 */
	public Scaled(P[][] data) {
		this.data = data;
	}

	// 0.1 <= factor <= 10.0; resize the picture
	@Override
	public void scale(double factor) {
		for(P[] a : data) {
			for(P pict : a) {
				pict.scale(factor);
			}
		}
	}

	@Override
	public String toString() {
		Table<P> table = new Table<P>(data);
		return table.renderTable();
	}
}
