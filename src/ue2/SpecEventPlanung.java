
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;

class SpecEventPlanung extends SpecificationTest {

	@Override
	protected String getSpecification() {
		return "Die Mitglieder der Musikgruppe sollen in die Planung\n"
				+ "der Proben und Auftritte eingebunden werden, indem Sie\n"
				+ "entsprechenden Terminvorschlaegen zustimmen oder diese ablehnen.\n"
				+ "Die Entscheidungen sollen mit kurzen Begruendungen versehen \n"
				+ "werden koennen.";
	}

	@Override
	public void test() throws ParseException, GesperrtException {
		MusikGruppe g = getDefaultMusikGruppe();
		ArrayList<Mitglied> members = new ArrayList<Mitglied>(g.getMembers());

		Event e = new Auftritt(new Ort("Wien"), date.parse("01.02.2012"),
				date.parse("02.02.2012"), new BigDecimal(120), g.getMembers(),
				date.parse("23.01.2012"), date.parse("31.01.2012"), 2);
		desc("Erzeuge: " + e.toString());
		ok(!e.isCanceled(), "Event findet statt");

		desc("Member " + members.get(0).toString() + " votet dafuer.");
		e.addVote(members.get(0), true, "OK");
		ok(e.getVotes().size() == 1, "Anzahl der Votes = 1");

		desc("Member " + members.get(0).toString() + " votet nochmal.");
		e.addVote(members.get(0), true, "OKOK");
		ok(e.getVotes().size() == 1, "Anzahl der Votes ist noch immer 1");

		desc("3 Member voten dagegen.");
		e.addVote(members.get(1), false, "Keine Zeit");
		e.addVote(members.get(2), false, "Nope");
		e.addVote(members.get(3), false, "Nono");

		ok(e.getVotes().size() == 4, "Anzahl der Votes = 4");
		ok(e.isCanceled(), "Event wurde abgesagt");
	}
}
