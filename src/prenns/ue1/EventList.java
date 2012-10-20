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

				if (type.isInstance(e)) {

					gesuchte.add(e);
				}
			}
		}

		return gesuchte;
	}
	
	public double getBilanz(Date von, Date bis) {
	
		ArrayList<Event> events = this.getEvent(von, bis);
		double summe = 0.00;
		
		for(Event e : events) {	
			summe += e.getBilanz();
		}
		
		return summe;
	}
	
	public double getBilanz(Date von, Date bis, Class<? extends Event> type) {
		
		ArrayList<Event> events = this.getEvent(von, bis, type);
		double result = 0.00;
		
		for(Event e : events) {
			result += e.getBilanz();
		}
		
		return result;
	}
}
