package ue2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MusikGruppeTest extends UnitTest {
	private static final DateFormat date = new SimpleDateFormat("d.M.y H:m");

	@Override
	public void start() {
		MusikGruppe g1 = new MusikGruppe("Oberkrainer", "Volksmusik");

		try {
			for (Event e : getEvents())
				g1.addEvent(e);

			testMusikGruppe(g1);

			testListEvents(g1);
			testSumme(g1);
		} catch (ParseException e) {
			ok(false, e.getMessage());
		}
	}

	private Iterable<Event> getEvents() throws ParseException {
		List<Event> e = new ArrayList<Event>();
		
		Ort o1 = new Ort("Wopfing");
		Ort o2 = new Ort("Wr. Neustadt");
		
		e.add(new Probe(o1, date.parse("10.02.2012 19:00"), 
				date.parse("10.02.2012 22:00"), 20));

		e.add(new Probe(o2, date.parse("20.02.2012 19:00"), 
				date.parse("20.02.2012 22:00"), 20));

		e.add(new Auftritt(o1, date.parse("21.02.2012 18:00"), 
				date.parse("21.02.2012 24:00"), 555));

		return e;
	}

	private void testMusikGruppe(MusikGruppe g1) {
		ok(g1.getAusrichtung() == "Volksmusik", "Ausrichtung ist Volksmusik");
		ok(g1.getName() == "Oberkrainer", "Name ist Oberkrainer");
	}

	private void testListEvents(MusikGruppe g1) throws ParseException {
		ok(g1.getEvents(date.parse("01.02.2012 19:00"),
						date.parse("30.02.2012 19:00")).size() == 3,
				"Anzahl aller Events zw. 01.02.2012 19:00-30.02.2012 19:00 ist 3");
		ok(g1.getEvents(date.parse("01.02.2011 19:00"),
						date.parse("30.02.2011 19:00")).size() == 0,
				"Anzahl aller Events zw. 01.02.2011 19:00-30.02.2011 19:00 ist 0");
		ok(g1.getEvents(date.parse("01.02.2012 19:00"),
						date.parse("30.02.2012 19:00"), Probe.class).size() == 2,
				"Anzahl der Proben zw. 01.02.2012 19:00-30.02.2012 19:00 ist 2");
		ok(g1.getEvents(date.parse("01.02.2012 19:00"),
						date.parse("30.02.2012 19:00"), Auftritt.class).size() == 1,
				"Anzahl der Auftritte zw. 01.02.2012 19:00-30.02.2012 19:00 ist 1");
	}

	private void testSumme(MusikGruppe g1) throws ParseException {
		ok(g1.getBilanz(date.parse("01.02.2012 19:00"),
				date.parse("30.02.2012 19:00")) == 515,
				"Der Gesamtgewinn/Verlust 01.02.2012 19:00-30.02.2012 19:00 ist 515 Gewinn.");
		ok(g1.getBilanz(date.parse("01.02.2012 19:00"),
				date.parse("30.02.2012 19:00"), Probe.class) == -40,
				"Die Gesamtkosten der Proben zw. 01.02.2012 19:00-30.02.2012 19:00 betraegt 40.");
	}
}
