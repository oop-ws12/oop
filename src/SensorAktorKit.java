import java.util.ArrayList;

public class SensorAktorKit extends ArrayList<Bauteil> {
	class SensorAktorKitValidator extends Validator {	
		private Software<?> software;
		public SensorAktorKitValidator(Software<?> software) {
			this.software = software;
		}
		
		protected boolean defaultValue() {
			double sum = getLeistungSum();
			return (software.getStufe() == 3 && sum <= 5) ||
				   (software.getStufe() == 4 && sum <= 10) ||
				   (software.getStufe() != 3 && software.getStufe() != 4);
		}
		
		@Override
		protected boolean value(Bediener a) {
			return getLeistungSum() <= 1;
		}

		@Override
		public Boolean visit(Kaempfer a) {
			return true;
		}
	}
	
	private static final long serialVersionUID = -2573176409685688411L;
	
	public <A extends Android> boolean validate(A a, Software<A> s) {
		return new SensorAktorKitValidator(s).visit(a);
	}
	
	private double getLeistungSum() {
		double sum = 0;
		for(Bauteil b : this) {
			sum += b.getLeistungKw();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("Sensor-Aktor-Kit:\n");
		for(Bauteil bauteil : this) {
			b.append("\t");
			b.append(bauteil.toString());
			b.append("\n");
		}
		return b.toString();
	}
}
