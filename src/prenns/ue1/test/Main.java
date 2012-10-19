package prenns.ue1.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import prenns.ue1.*;

public class Main {

	private static final SimpleDateFormat format = new SimpleDateFormat("d.M.y");

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			MusikGruppe grp = new MusikGruppe("ACDC", "Rock");

			EventTest(grp);
			ArchivTest(grp);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public static void EventTest(MusikGruppe grp) throws ParseException {

		grp.newEvent(new Auftritt("Wien", format.parse("03.10.1991"), format
				.parse("03.11.1991 00:00"), 12.00));

		grp.newEvent(new Probe("Wopfing", format.parse("05.01.1991"), format
				.parse("06.01.1991 00:00"), 12.00));

		grp.newEvent(new Probe("Wopfing", format.parse("05.04.1991"), format
				.parse("06.04.1991"), 12.00));

		Collection<Event> events = new ArrayList<Event>();

		events = grp.getEvents(format.parse("05.01.1991"),
				format.parse("31.01.1992"), Event.class);

		assert (events.size() == 3);
	}

	public static void ArchivTest(MusikGruppe grp) throws ParseException {

		Mitglied m1 = new Mitglied("Alex", "1234", "Bass");
		Mitglied m2 = new Mitglied("Lukas", "22234", "Triangel");
		Mitglied m3 = new Mitglied("Jimmy", "1232224", "Trommel");

		grp.newMember(m1, format.parse("03.10.1991"));
		grp.newMember(m2, format.parse("06.11.2012"));
		grp.newMember(m3, format.parse("22.05.1998"));

		Collection<Mitglied> members = new ArrayList<Mitglied>();
		
		boolean test = grp.removeMember(m1, format.parse("08.11.2013"));

		System.out.println(test);

		members = grp.getMembers();

		for (Mitglied m : members) {

			System.out.println(m);
		}

	}

}
