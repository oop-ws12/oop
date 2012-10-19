package prenns.ue1;

import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("serial")
public class EventList extends ArrayList<Event>  {

	public ArrayList<Event> getEvent(Date von, Date bis) {

		return getEvent(von, bis, Event.class);
	}

	public ArrayList<Event> getEvent(Date von, Date bis,
			Class<? extends Event> type) {

		ArrayList<Event> gesuchte = new ArrayList<Event>();

		for (Event e : this) {

			if (e.getAnfang().compareTo(bis) <= 0
					&& von.compareTo(e.getEnde()) <= 0) {

				if (e.getClass() == type) {

					gesuchte.add(e);
				}
			}
		}

		return gesuchte;
	}
}
