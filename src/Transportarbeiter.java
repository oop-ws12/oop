public class Transportarbeiter extends Schwerarbeiter {
	
	public static abstract class BasicSoftware extends Software<Transportarbeiter>
			implements AndroidVerordnung {
		@Override
		public boolean validate(Transportarbeiter a) {
			return getStufe() == 3 || getStufe() == 4;
		}
	}

	@Override
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
