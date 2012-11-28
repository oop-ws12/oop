/**
 * Android fuer Reinigungsaufgaben
 */
public class Hilfskraft extends Bediener {

	public static abstract class BasicSoftware extends Software<Hilfskraft>
			implements AndroidVerordnung {
		@Override
		public boolean validate(Hilfskraft a) {
			return getStufe() == 1;
		}
	}

	@Override
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
