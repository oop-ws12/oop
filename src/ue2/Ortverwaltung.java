
import java.util.ArrayList;
import java.util.Collection;

/**
 * Stellt eine Liste von Orten dar.
 */
public class Ortverwaltung extends ArrayList<Ort> {

	private static final long serialVersionUID = 948533179790990384L;

	/**
	 * Liefert eine Liste von Orten die ideal waeren, fuer eine bestimmte Art von Event.
	 * @param type != null
	 * @return
	 */
	public Collection<Ort> getIdealOrte(EventType type) {
		Collection<Ort> result = new ArrayList<Ort>();

		for (Ort o : this) {
			if (o.hasIdealInfra(type)) {
				result.add(o);
			}
		}

		return result;
	}
}
