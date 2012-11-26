/**
 * Bediener sind leichtgewichtige, flinke und ausdauernde Androiden, 
 * die normalerweise in der Naehe von und in direktem Kontakt zu Menschen 
 * eingesetzt werden.
 */
public abstract class Bediener extends Android {
	public static abstract class BasicSoftware extends Software<Bediener> implements AndroidVerordnung {		
		@Override
		public boolean validate(Bediener a) {
			return getStufe() == 1 || getStufe() == 2;
		}
	}
	
	@Override
	public <T> T dispatch(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
