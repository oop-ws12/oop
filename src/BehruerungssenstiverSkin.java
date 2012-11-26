public class BehruerungssenstiverSkin extends Skin {
	// Bediener benoetigen unbedingt eine beruehrungssensitive Skin
	static class SkinValidator extends Skin.SkinValidator {
		@Override
		protected boolean value(Bediener a) {
			return true;
		}
	}
	
	private static Validator validator = new SkinValidator();
	@Override
	protected Validator getValidator() {
		return validator;
	}
	
	@Override
	public String toString() {
		return "Behruerungsensitiver Skin";
	}
}
