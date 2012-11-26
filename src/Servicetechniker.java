
public class Servicetechniker extends Schwerarbeiter {
	@Override
	public <T> T visit(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
