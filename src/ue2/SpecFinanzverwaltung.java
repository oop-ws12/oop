
import java.math.BigDecimal;

public class SpecFinanzverwaltung extends SpecificationTest {

	@Override
	protected String getSpecification() {
		return "Neben Raummieten und Gagen fallen viele weitere Kosten und gelegentlich auch Einnahmen an.\n"
				+ "Diese sollen direkt im System verwaltet werden.\n"
				+ "Die Zuordnung zwischen Auftritten bzw. Proben und Einnahmen bzw. Kosten soll weitestgehend erhalten bleiben,\n"
				+ "aber auch Einnahmen und Kosten, die nicht eindeutig zuzuordnen sind, sollen abgebildet werden.";
	}

	@Override
	public void test() throws Exception {

		MusikGruppe g1 = this.getDefaultMusikGruppe();

		desc("Fuege sonstige Kosten/Einnahmen hinzu:");

		AllgemeinFinanzen a1 = new AllgemeinFinanzen(date.parse("03.10.2012"),
				new BigDecimal(40), "Merchandising");
		AllgemeinFinanzen a2 = new AllgemeinFinanzen(date.parse("05.11.2012"),
				new BigDecimal(-100), "Werbekosten");
		AllgemeinFinanzen a3 = new AllgemeinFinanzen(date.parse("03.10.2012"),
				new BigDecimal(100), "Sonstige Einnahmen");
		AllgemeinFinanzen a4 = new AllgemeinFinanzen(date.parse("03.10.2012"),
				new BigDecimal(-100), "Werbekosten");

		desc("sonstige Kosten/Einahmen der Gruppe hinzufuegen");
		ok(g1.addFinanz(a1), "Merchandising adden");
		ok(g1.addFinanz(a2), "Werbekosten adden");
		ok(g1.addFinanz(a3), "Sonstige Einnahmen adden");
		ok(g1.addFinanz(a4), "Werbekosten adden");

		desc("Bilanz fuer alle Finanzen im Jahr 2012:");
		ok(g1.getBilanz(date.parse("01.01.2012"), date.parse("31.12.2012"))
				.compareTo(new BigDecimal(455)) == 0,
				"Bilanzergebnis fuer Jahr 2012 is 555 Gewinn");

		desc("Bilanz fuer alle Werbekosten im Jahr 2012");
		ok(g1.getBilanz(date.parse("01.01.2012"),
				date.parse("31.12.2012"), "Werbekosten").compareTo(
				new BigDecimal(-200)) == 0, "-200 Kosten fuer Werbeung im Jahr 2012");

	}

}
