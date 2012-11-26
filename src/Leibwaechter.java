
public class Leibwaechter extends Beschuetzer {
	public static abstract class BasicSoftware extends Software<Leibwaechter> implements AndroidVerordnung {		
		@Override
		public boolean validate(Leibwaechter a) {
			return getStufe() == 4;
		}
	}
	
	@Override
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
