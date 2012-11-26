/**
 * Schwerarbeiter sind kraeftige, ausdauernde Androiden, 
 * die mit schweren Lasten umgehen können und den Kontakt zu 
 * Menschen aus Sicherheitsgruenden meiden.
 */
public abstract class Schwerarbeiter extends Android {
	// Gesselschaftersoftware erbt von dieser Klasse
	public static abstract class BasicSoftware extends Software<Schwerarbeiter> implements AndroidVerordnung {
		@Override
		public boolean validate(Schwerarbeiter a) {
			return getStufe() == 3 || getStufe() == 4;
		}
	}
	
	@Override
	public <T> T visit(AndroidVisitor<T> v) {
		return v.visit(this);
	}
}
