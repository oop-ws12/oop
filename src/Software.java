/**
 * Eine Software fuer einen bestimmten Typ.
 */
public abstract class Software<A extends Android> {
	/**
	 * Validiert die Software nach einem Androiden.
	 * @param a der Androide
	 * @return
	 */
	public abstract boolean validate(A a);

	/**
	 * @return Die Sicherheitsstufe der Software
	 */
	public abstract int getStufe();
}
