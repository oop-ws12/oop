/**
 * Ein Skin fuer Androiden.
 */
public abstract class Skin {
	static class SkinValidator extends Validator {		
		// Bediener benoetigen unbedingt eine beruehrungssensitive Skin
		@Override
		protected boolean value(Bediener a) {
			return false;
		}

		@Override
		protected boolean defaultValue() {
			return true;
		}
	}
	
	private static Validator validator = new SkinValidator();
	protected Validator getValidator() {
		return validator;
	}
	
	/**
	 * Validiert die Instanz nach der Android Verordnung.
	 * @param a der Android
	 * @return
	 */
	public boolean validate(Android a) {
		return a.dispatch(getValidator());
	}
}
