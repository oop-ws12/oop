/**
 * Android zur Unterhaltung oder Kinderbetreuung
 */
public class Gesellschafter extends Bediener {
	// Gesselschaftersoftware erbt von dieser Klasse
	public static abstract class BasicSoftware extends Software<Gesellschafter> implements AndroidVerordnung {
		@Override
		public boolean validate(Gesellschafter a) {
			return getStufe() == 1;
		}
	}
	
	@Override
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
