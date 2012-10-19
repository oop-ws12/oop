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

		MusikGruppe grp = new MusikGruppe("ACDC", "Rock");
		
	}

	public static void EventTest(MusikGruppe grp) {
		try {
			grp.newEvent(new Auftritt("Wien", format.parse("03.10.1991 00:00"),
					format.parse("03.11.1991 00:00"), 12.00));

			grp.newEvent(new Probe("Wopfing", format.parse("05.01.1991 00:00"),
					format.parse("06.01.1991 00:00"), 12.00));

			grp.newEvent(new Probe("Wopfing", format.parse("05.04.1991 00:00"),
					format.parse("06.04.1991 00:00"), 12.00));

			Collection<Event> events = new ArrayList<Event>();

			events = grp.getEvents(format.parse("05.01.1991 00:00"),
					format.parse("31.01.1991 00:00"), Probe.class);

			for (Event e : events) {

				System.out.println(e);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	public static void ArchivTest(MusikGruppe grp) {
		
		
	}

}
