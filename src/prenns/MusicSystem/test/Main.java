package prenns.MusicSystem.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import prenns.MusicSystem.*;

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
			System.out.println(e.getMessage());
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

		double bilanz = grp.getBilanz(format.parse("01.01.1991"),
				format.parse("31.12.1991"), Probe.class);
		
		System.out.println(bilanz);

		assert (bilanz == -24.0);
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

		boolean test = grp.removeMember(m3, format.parse("08.11.2012"));

		assert (test == true);

		members = grp.getMembers();

		for (Mitglied m : members) {

			System.out.println(m);
		}

		System.out.println("Members am 05.06.2010:");

		Collection<Mitglied> oldMembers = new ArrayList<Mitglied>();

		oldMembers = grp.getMembers(format.parse("05.06.2010"));

		for (Mitglied m : oldMembers) {

			System.out.println(m);
		}

	}

}
