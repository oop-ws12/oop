package ue2;

import java.math.BigDecimal;

public class SpecChangeEvent extends SpecificationTest {

	@Override
	protected String getSpecification() {
		return "Entfernen oder Aendern einer Probe oder eines Auftritts\n"
				+ "ist vor allem zur Korrektur falscher Daten notwendig.\n"
				+ "Dabei sollen die entfernten oder geaederten Daten nicht\n"
				+ "verlorengehen, sondern bei Bedarf wieder rekonstruiert werden\n"
				+ "koennen.";
	}

	@Override
	public void test() throws Exception {
		MusikGruppe g = getDefaultMusikGruppe();

		Ort wien = new Ort("Wien");
		Ort neustadt = new Ort("Wiener Neustadt");

		Event f = new Auftritt(wien, date.parse("20.03.2012"),
				date.parse("21.03.2012"), new BigDecimal(220), g.getMembers(),
				date.parse("13.03.2012"), date.parse("20.03.2012"), 2);
		desc("Erzeuge Auftritt " + f);

		desc("Fuege Event zur Liste hinzu, ab nun Ueberwacht die Liste das Event auf Aenderungen.");
		g.addEvent(f);

		desc("Aendere Ort auf Wr. Neustadt");
		f.setOrt(neustadt);

		desc("Verschiebe auf 22.03.2012 - 24.03.2012");
		f.setZeitraum(date.parse("22.03.2012"), date.parse("24.03.2012"));

		Entry<Event> eintrag = g.getEventEntry(f);
		ok(eintrag != null, "Finde Eintrag fuer das Event");

		ok(eintrag.getRevisions().size() == 2, "Anzahl der Revisionen ist 2");

		ok(eintrag.getRevisions().get(0).getValue().getOrt() == wien,
				"Aenderungen wurden gespeichert: Bei der ersten Revision ist der Ort Wien");

		Entry<Event>.Revision r2 = eintrag.getRevisions().get(1);
		desc("Stelle Revision 2 vom " + date.format(r2.getDate())
				+ " wieder her: " + r2.getValue());
	}
}
