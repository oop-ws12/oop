// kein untertyp von Repeated<P> da sich scale anderst verhaelt.
public class Scaled<P extends Pict> implements Pict {
	// constant after initialization
	// rectangular array
	private P[][] data;
	
	/**
	 * @param data
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

}
