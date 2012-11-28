public class Servicetechniker extends Schwerarbeiter {
	
	public static abstract class BasicSoftware extends Software<Servicetechniker>
			implements AndroidVerordnung {
		@Override
		public boolean validate(Servicetechniker a) {
			return getStufe() == 3 || getStufe() == 4;
		}
	}

	@Override
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
