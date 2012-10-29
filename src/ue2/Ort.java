
import java.util.ArrayList;
import java.util.Collection;

/**
 * Stellt einen Ort dar.
 */
public class Ort {
	private String name;
	private Collection<Infrastruktur> infra;

	/**
	 * @param name != null
	 */
	public Ort(String name) {
		this.name = name;
		infra = new ArrayList<Infrastruktur>();
	}

	/**
	 * Liefert den Namen des Ortes.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * SCHLECHT: Es sollten nicht die einzelnen Parameter uebergeben werden, 
	 * sondern gleich eine Infrastruktur Instanz.
	 * 
	 * Deklariert eine Infrastruktur im Ort.
	 * @param type != null
	 * @param anfahrt != null
	 * @param beschreibung != null
	 * @return true falls die Liste erfolgreich hinzugefuegt worden ist
	 */
	public boolean addInfra(EventType type, String anfahrt, String beschreibung) {
		return infra.add(new Infrastruktur(type, anfahrt, beschreibung));
	}
	
	/**
	 * Prueft ob der Ort eine geeignet Infrastruktur fuer das uebergebene Event besitzt
	 * @param type != null
	 * @return true falls der Ort eine geeignete Infrastuktur bestitzt,
	 */
	public boolean hasIdealInfra(EventType type) {
		for(Infrastruktur i : infra) {
			if(i.getType().equals(type)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Ort [" + name + "]";
	}
}
