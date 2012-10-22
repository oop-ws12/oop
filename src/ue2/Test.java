package ue2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ue1.Auftritt;
import ue1.Event;
import ue1.Lied;
import ue1.Mitglied;
import ue1.MusikGruppe;
import ue1.Probe;
import ue1.lists.DeletionList;

public class Test extends TestCase {
	private static final DateFormat date = new SimpleDateFormat("d.M.y H:m");

	@Override
	public void test() {
		group("MusikGruppe");
		
		desc("Erzeuge Musikgruppe Oberkrainer mit Ausrichtung Volksmusik");
		MusikGruppe g1 = new MusikGruppe("Oberkrainer", "Volksmusik");

		try {
			for (Event e : getEvents())
				g1.getEvents().add(e);

			testMusikGruppe(g1);

			testListEvents(g1);
			testSumme(g1);

			testMitglieder(g1);
			testRepertoire(g1);

			testDeletionList();
		} catch (ParseException e) {
			ok(false, e.getMessage());
		}
	}

	private Iterable<Event> getEvents() throws ParseException {
		List<Event> e = new ArrayList<Event>();
		
		desc("Fuege hinzu: Probe in Wopfing am 10.02.2012 19:00 mit Kosten 20");
		e.add(new Probe("Wopfing", date.parse("10.02.2012 19:00"), 
				date.parse("10.02.2012 22:00"), 20));

		desc("Fuege hinzu: Probe in Wr. Neustadt am 20.02.2012 19:00 mit Kosten 20");
		e.add(new Probe("Wr. Neustadt", date.parse("20.02.2012 19:00"), 
				date.parse("20.02.2012 22:00"), 20));

		desc("Fuege hinzu: Auftritt in Wopfing am 21.02.2012 18:00 mit Gage 555");
		e.add(new Auftritt("Wopfing", date.parse("21.02.2012 18:00"), 
				date.parse("21.02.2012 24:00"), 555));

		return e;
	}

	private void testMitglieder(MusikGruppe g1) throws ParseException {
		group("Mitglieder");

		Date gruendung = date.parse("01.02.2012 19:00");
		Date j = date.parse("01.03.2012 19:00");

		Mitglied m1 = new Mitglied("Lukas", "00", "Trommel");
		Mitglied m2 = new Mitglied("Alex", "01", "Floete");

		desc("Mitglied Lukas(Trommel) tritt ein (01.03.2012 19:00)");
		g1.getMitglieder().add(m1, j);

		desc("Mitglied Alex(Floete) tritt ein (01.03.2012 19:00)");
		g1.getMitglieder().add(m2, j);

		ok(g1.getMitglieder().size() == 2, "Anzahl der Mitglieder ist 2");
		ok(g1.getMitglieder().list(gruendung).size() == 0,
				"Anzahl der Mitglieder am 01.02.2012 ist 0");

		ok(g1.getMitglieder().remove(m1), "Lukas tritt aus");
		ok(g1.getMitglieder().list().size() == 1, "Anzahl der Mitglieder ist 1");
		ok(g1.getMitglieder().list(j).size() == 2,
				"Anzahl der Mitglieder am 01.03.2012 19:00 ist 2");
	}

	private void testRepertoire(MusikGruppe g1) throws ParseException {
		group("Repertoire");

		Date gruendung = date.parse("01.02.2012 19:00");
		Date j = date.parse("01.03.2012 19:00");

		Lied m1 = new Lied("Intro", 30);
		Lied m2 = new Lied("Lala", 200);

		desc("Lied Intro wird komponiert am 01.03.2012 19:00");
		g1.getRepertoire().add(m1, j);

		desc("Lied Lala wird komponiert am 01.03.2012 19:00");
		g1.getRepertoire().add(m2, j);

		ok(g1.getRepertoire().size() == 2, "Anzahl der Lieder ist 2");
		ok(g1.getRepertoire().list(gruendung).size() == 0,
				"Anzahl der Lieder am 01.02.2012 ist 0");
	}

	private void testMusikGruppe(MusikGruppe g1) {
		ok(g1.getAusrichtung() == "Volksmusik", "Ausrichtung ist Volksmusik");
		ok(g1.getName() == "Oberkrainer", "Name ist Oberkrainer");
	}

	private void testListEvents(MusikGruppe g1) throws ParseException {
		group("Events");

		ok(g1
				.getEvents()
				.list(date.parse("01.02.2012 19:00"),
						date.parse("30.02.2012 19:00")).size() == 3,
				"Anzahl aller Events zw. 01.02.2012 19:00-30.02.2012 19:00 ist 3");
		ok(g1
				.getEvents()
				.list(date.parse("01.02.2011 19:00"),
						date.parse("30.02.2011 19:00")).size() == 0,
				"Anzahl aller Events zw. 01.02.2011 19:00-30.02.2011 19:00 ist 0");
		ok(g1
				.getEvents()
				.list(date.parse("01.02.2012 19:00"),
						date.parse("30.02.2012 19:00"), Probe.class).size() == 2,
				"Anzahl der Proben zw. 01.02.2012 19:00-30.02.2012 19:00 ist 2");
		ok(g1
				.getEvents()
				.list(date.parse("01.02.2012 19:00"),
						date.parse("30.02.2012 19:00"), Auftritt.class).size() == 1,
				"Anzahl der Auftritte zw. 01.02.2012 19:00-30.02.2012 19:00 ist 1");
	}

	private void testSumme(MusikGruppe g1) throws ParseException {
		ok(g1.getEvents().summe(date.parse("01.02.2012 19:00"),
				date.parse("30.02.2012 19:00")) == 515,
				"Der Gesamtgewinn/Verlust 01.02.2012 19:00-30.02.2012 19:00 ist 515 Gewinn.");
		ok(g1.getEvents().summe(date.parse("01.02.2012 19:00"),
				date.parse("30.02.2012 19:00"), Probe.class) == -40,
				"Die Gesamtkosten der Proben zw. 01.02.2012 19:00-30.02.2012 19:00 betraegt 40.");
	}

	private void testDeletionList() throws ParseException {
		DeletionList<String> l = new DeletionList<String>();
		Date z1 = date.parse("01.02.2012 19:00");
		Date z2 = date.parse("01.03.2012 19:00");

		l.add("s1", z1);
		l.add("s2", z1);
		l.add("s3", z1);
		l.add("s4", z2);

		assert l.list().size() == 4;
		assert l.list(z1).size() == 3;

		assert l.remove("s4");
		assert l.list().size() == 3;
		assert l.list(z1).size() == 3;

		l.remove("s1");
		assert l.list().size() == 2;
		assert l.list(z1).size() == 3;
	}
}
