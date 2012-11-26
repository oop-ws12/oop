/**
 * Android fuer Reinigungsaufgaben
 */
public class Hilfskraft extends Bediener {
	@Override
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
