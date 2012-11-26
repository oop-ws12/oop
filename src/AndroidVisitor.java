
public interface AndroidVisitor<T> {
	T visit(Android a);
	T visit(Beschuetzer a);
	T visit(Bediener a);
	T visit(Kaempfer a);
}
