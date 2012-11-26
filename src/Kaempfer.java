
public class Kaempfer extends Beschuetzer {
	public static abstract class BasicSoftware extends Software<Kaempfer> implements AndroidVerordnung {		
		@Override
		public boolean validate(Kaempfer a) {
			return getStufe() == 5;
		}
	}
	
	@Override
	public <T> T visit(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
