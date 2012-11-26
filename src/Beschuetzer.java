/**
 * Beschützer sind kraeftige und flinke Androiden, 
 * die zum Schutz von Menschen und Objekten Einsatz finden. 
 * Außer in gefaehrlichen Situationen meiden sie den Kontakt zu Menschen.
 */
public abstract class Beschuetzer extends Android {
	@Override
	public <T> T visit(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
