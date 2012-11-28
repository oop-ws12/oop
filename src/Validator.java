/**
 * Stellt einen Validator dar, der ein bestimtes Zubehoerteil fuer einen Android validiert.
 * 
 * Liefter fuer jede Methode true falls die keine Fehler aufgetreten sind (der Android zu dem Teil passt)
 */
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
