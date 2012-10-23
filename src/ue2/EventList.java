/**
 * 
 */
package ue2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Eine Liste von Events der MusikGruppe.
 */
public class EventList extends DeletionList<Event> {
	/**
	 * Listet Events eines bestimmten Typs zu einem bestimmten Zeitraum.
	 * 
	 * @param begin
	 * @param end
	 * @param type
	 * @return
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
	 * @param begin
	 * @param end
	 * @return
	 */
	public Collection<Event> list(Date begin, Date end) {
		return list(begin, end, Event.class);
	}

}
