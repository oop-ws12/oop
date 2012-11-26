
public class Leibwaechter extends Beschuetzer {
	@Override
	public <T> T visit(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
