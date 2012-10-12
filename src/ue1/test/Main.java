package ue1.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ue1.Auftritt;
import ue1.DeletionList;
import ue1.Event;
import ue1.Lied;
import ue1.Mitglied;
import ue1.MusikGruppe;
import ue1.Probe;

public class Main {
	private static final DateFormat date = new SimpleDateFormat("d.M.y H:m");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			test();
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test() throws ParseException {
		MusikGruppe g1 = new MusikGruppe("Oberkrainer", "Volksmusik");
		
		for(Event e : getEvents())
			g1.addEvent(e);
		
		testDeletionList();
		testMusikGruppe(g1);
		testListEvents(g1);
		testSumme(g1);
		testMitglieder(g1);
		testRepertoire(g1);
	}
		
	private static Iterable<Event> getEvents() throws ParseException
	{
		List<Event> e = new ArrayList<Event>();
		e.add(new Probe("Wopfing", date.parse("10.02.2012 19:00"), date.parse("10.02.2012 22:00"), 20));
		e.add(new Probe("Wr. Neustadt", date.parse("20.02.2012 19:00"), date.parse("20.02.2012 22:00"), 20));
		e.add(new Auftritt("Wopfing", date.parse("21.02.2012 18:00"), date.parse("21.02.2012 24:00"), 555));
		
		return e;
	}
	
	private static void testMitglieder(MusikGruppe g1) throws ParseException {
		Date gruendung = date.parse("01.02.2012 19:00");
		Date j = date.parse("01.03.2012 19:00");
		
		Mitglied m1 = new Mitglied("Lukas", "00", "Trommel");
		Mitglied m2 = new Mitglied("Alex", "01", "Floete");
		
		g1.getMitglieder().add(m1, j);
		g1.getMitglieder().add(m2, j);
		
		assert g1.getMitglieder().list().size() == 2;
		assert g1.getMitglieder().list(gruendung).size() == 0;
		assert g1.getMitglieder().list(j).size() == 2;
		
		assert g1.getMitglieder().remove(m1);
		assert g1.getMitglieder().list().size() == 1;
		assert g1.getMitglieder().list(j).size() == 2;
	}
	
	private static void testRepertoire(MusikGruppe g1) throws ParseException {
		Date gruendung = date.parse("01.02.2012 19:00");
		Date j = date.parse("01.03.2012 19:00");
		
		Lied m1 = new Lied("Intro", 30);
		Lied m2 = new Lied("Lala", 200);
		
		g1.getRepertoire().add(m1, j);
		g1.getRepertoire().add(m2, j);
		
		assert g1.getRepertoire().list().size() == 2;
		assert g1.getRepertoire().list(gruendung).size() == 0;
		assert g1.getRepertoire().list(j).size() == 2;
		
		assert g1.getRepertoire().remove(m1);
		assert g1.getRepertoire().list().size() == 1;
		assert g1.getRepertoire().list(j).size() == 2;
	}
	
	private static void testMusikGruppe(MusikGruppe g1) {
		assert g1.getAusrichtung() == "Volksmusik";
		assert g1.getName() == "Oberkrainer";
	}

	private static void testListEvents(MusikGruppe g1) throws ParseException {
		assert g1.listEvents(date.parse("01.02.2012 19:00"), date.parse("30.02.2012 19:00")).size() == 3;
		assert g1.listEvents(date.parse("01.02.2011 19:00"), date.parse("30.02.2011 19:00")).size() == 0;
		assert g1.listEvents(date.parse("01.02.2012 19:00"), date.parse("30.02.2012 19:00"), Probe.class).size() == 2;
		assert g1.listEvents(date.parse("01.02.2012 19:00"), date.parse("30.02.2012 19:00"), Auftritt.class).size() == 1;
	}
	
	private static void testSumme(MusikGruppe g1) throws ParseException {
		assert g1.summe(date.parse("01.02.2012 19:00"), date.parse("30.02.2012 19:00")) == 515;
		assert g1.summe(date.parse("01.02.2012 19:00"), date.parse("30.02.2012 19:00"), Probe.class) == -40;
	}
	
	private static void testDeletionList() throws ParseException {
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
