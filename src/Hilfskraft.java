/**
 * Android fuer Reinigungsaufgaben
 */
public class Hilfskraft extends Bediener {
	@Override
	public <T> T visit(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
