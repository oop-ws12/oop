public class GepanzerterSkin extends Skin {
	// nur Beschuetzer duerfen eine gepanzerte Skin haben
	static class SkinValidator extends Skin.SkinValidator implements AndroidVerordnung {
		@Override
		protected boolean defaultValue() {
			return false;
		}
		
		@Override
		protected boolean value(Beschuetzer a) {
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
		return "Gepanzerter Skin";
	}
}
