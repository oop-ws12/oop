/**
 * 
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * SCHLECHT: Klasse wurde als public deklariert, wird aber nicht
 * benoetig, um die Oeffentliche API zur Verwaltung der Musikgruppe, zu nutzen.
 *
 * GUT: Eine eigne Klasse, welche die normale DeletionList 
 * erweitert und sich um die Ausgabe von Events mit in einem
 * bestimmten Zeitraum kuemmert.
 * 
 * Eine Liste von Events der MusikGruppe.
 */
public class EventList extends DeletionList<Event> {
	/**
	 * Listet Events eines bestimmten Typs zu einem bestimmten Zeitraum.
	 * 
	 * @param begin != null
	 * @param end != null && end > begin
	 * @param type != null
	 * @return Collection<Event>
	 */
	public Collection<Event> list(Date begin, Date end,
			Class<? extends Event> type) {
		List<Event> filtered = new ArrayList<Event>();

		for (Event e : this) {
			boolean inRange = begin.compareTo(e.getEnde()) <= 0
					&& e.getBeginn().compareTo(end) <= 0;
			if (type.isAssignableFrom(e.getClass()) && inRange) {
				filtered.add(e);
			}
		}

		return filtered;
	}

	/**
	 * Listet alle Events in einem bestimmten Zeitraum.
	 * 
	 * @param begin != null	
	 * @param end != null && end > begin
	 * @return Collection<Event>
	 */
	public Collection<Event> list(Date begin, Date end) {
		return list(begin, end, Event.class);
	}

}
