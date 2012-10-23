package ue2;

public class SpecLiedVarianten extends SpecificationTest {

	@Override
	protected String getSpecification() {
		return 	"Zu jedem Musikstueck kann es mehrere Varianten geben. \n" +
				"Beim Auflisten koennen Varianten entweder getrennt voneinander\n" +  
				"oder gemeinsam betrachtet werden. Bei gemeinsamer Betrachtung \n" +
				"kann ein Musikstueck unterschiedliche Laengen aufweisen.";
	}

	@Override
	public void test() throws Exception {
		Lied l1 = new Lied("Hardcore Beat", 200);
		desc("Erzeuge Lied " + l1.toString());
		
		desc("Fuege Variante hinzu: Club Version");
		l1.addVariante("Club Version", 630);
		
		desc("Fuege Variante hinzu: Vocal Mix");
		l1.addVariante("Vocal Mix", 200);
		
		ok(l1.getVarianten().size() == 3, "Anzahl der Varianten muss 3 sein.");
		desc(l1.toString());
	}

}
