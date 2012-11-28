public class Bauarbeiter extends Schwerarbeiter {
	
	public static abstract class BasicSoftware extends Software<Bauarbeiter>
			implements AndroidVerordnung {
		@Override
		public boolean validate(Bauarbeiter a) {
			return getStufe() == 3 || getStufe() == 4;
		}
	}
	
	@Override
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
