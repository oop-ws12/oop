
public abstract class Validator implements AndroidVisitor<Boolean> {
	protected abstract boolean defaultValue();
	protected boolean value(Beschuetzer a) {
		return defaultValue();
	}
	protected boolean value(Bediener a) {
		return defaultValue();
	}
	protected boolean value(Schwerarbeiter a) {
		return defaultValue();
	}
	
	@Override
	public Boolean visit(Android a) {
		return defaultValue();
	}

	@Override
	public Boolean visit(Beschuetzer a) {
		return value(a);
	}

	@Override
	public Boolean visit(Bediener a) {
		return value(a);
	}

	@Override
	public Boolean visit(Kaempfer a) {
		return value(a);
	}
}
