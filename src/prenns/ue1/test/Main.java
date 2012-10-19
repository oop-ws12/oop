package prenns.ue1.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import prenns.ue1.*;

public class Main {

	private static final SimpleDateFormat format = new SimpleDateFormat(
			"d.M.y H:m");

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MusikGruppe grp = new MusikGruppe("ACDC", "Rock");

		try {
			grp.newEvent(new Auftritt("Wien", format.parse("03.10.1991 00:00"),
					format.parse("03.11.1991 00:00"), 12.00));
			
			grp.newEvent(new Probe("Wopfing", format.parse("05.01.1991 00:00"),
					format.parse("06.01.1991 00:00"), 12.00));
			
			grp.newEvent(new Probe("Wopfing", format.parse("05.04.1991 00:00"),
					format.parse("06.04.1991 00:00"), 12.00));
			
			ArrayList<Event> events = new ArrayList<Event>();
			
			events = grp.getEvent(format.parse("05.01.1991 00:00"), format.parse("31.01.1991 00:00"), Probe.class);
			
			for(Event e : events) {
				
				System.out.println(e);
			}
			

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	

	}

}
