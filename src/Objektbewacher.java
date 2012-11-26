
public class Objektbewacher extends Beschuetzer {
	public static abstract class BasicSoftware extends Software<Objektbewacher> implements AndroidVerordnung {		
		@Override
		public boolean validate(Objektbewacher a) {
			return getStufe() == 4;
		}
	}
	
	@Override
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
