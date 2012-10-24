
import java.util.ArrayList;
import java.util.Collection;

public class Ortverwaltung extends ArrayList<Ort> {

	private static final long serialVersionUID = 948533179790990384L;

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
