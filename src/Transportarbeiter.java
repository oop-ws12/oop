
public class Transportarbeiter extends Schwerarbeiter {
	@Override
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
