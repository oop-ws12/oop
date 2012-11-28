/**
 * Ein Visitor nach dem Vistior-Pattern, es werden nur die benoetigten
 * Methoden bereitgestellt.
 * @param <T> der Rueckgabetyp der Visitor methoden
 */
public interface AndroidVisitor<T> {
	T visit(Android a);
	T visit(Beschuetzer a);
	T visit(Bediener a);
	T visit(Kaempfer a);
}
