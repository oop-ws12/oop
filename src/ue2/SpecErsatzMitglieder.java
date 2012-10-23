package ue2;

import java.math.BigDecimal;

public class SpecErsatzMitglieder extends SpecificationTest {

	@Override
	protected String getSpecification() {
		return "Die Musikgruppe hat neben permanenten Mitgliedern auch Ersatzmitglieder, die nur im Bedarfsfall zum Einsatz kommen.\n"
				+ "Pro Probe und Auftritt kann sich die Zusammensetzung unterscheiden und ist im System festzuhalten.\n"
				+ " Es kann auch zu Verschiebungen kommen, wobei ein permanentes Mitglied zu einem Ersatzmitglied wird und umgekehrt.\n"
				+ "Ersatzmitglieder, die nicht an einer Mindestzahl an Proben pro Zeiteinheit teilnehmen, werden für Auftritte gesperrt.\n";
	}

	@Override
	public void test() throws Exception {

		MusikGruppe g1 = this.getDefaultMusikGruppe();

		Ort o1 = new Ort("Wien");

		desc("Mache 1 Mitglied zu Ersatzmitglied und fuege es hinzu");

		Mitglied m1 = new Mitglied("Armin", "04", "Bass");

		ok(g1.addMember(m1), "M1 zu G1 adden");
		m1.setErsatz(true);

		try {
			desc("Ertelle neuen Auftritt");
			Auftritt a1 = new Auftritt(o1, date.parse("20.12.2012"),
					date.parse("21.12.2012"), new BigDecimal(200),
					g1.getMembers(), date.parse("01.01.2012"),
					date.parse("19.12.2012"), 2);
			g1.addEvent(a1);
		} catch (GesperrtException e) {
			ok(true,
					"Mitglied ist gesperrt, da Ersatz und noch an keinen Proben dieses Jahr Teilgenommen");
		}

	}

}
