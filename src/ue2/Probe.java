
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * Stellt eine Probe der MusikGruppe dar.
 */
public class Probe extends Event {
	// >= 0
	private BigDecimal raumMiete;

	public Probe(Ort ort, Date beginn, Date end, BigDecimal raumMiete, Collection<Mitglied> setup) {
		super(ort, beginn, end, setup);
		this.raumMiete = raumMiete;
		
		for(Mitglied m : setup) {
			m.addProbe(this);
		}
	}

	public Probe(Probe o) {
		super(o);
		this.raumMiete = o.raumMiete;
	}

	/**
	 * Liefert die Raummiete.
	 * @return
	 */
	public BigDecimal getRaumMiete() {
		return raumMiete;
	}

	/**
	 * Setzt die Raummiete.
	 * @param raumMiete >= 0
	 */
	public void setRaumMiete(BigDecimal raumMiete) {
		this.observers.before(changed);
		this.raumMiete = raumMiete;
		this.observers.fire(changed);
	}

	@Override
	public BigDecimal getWert() {
		return raumMiete.multiply(new BigDecimal(-1));
	}

	@Override
	public String toString() {
		return "Probe [raummiete=" + getRaumMiete() + ", ort=" + getOrt() + "]";
	}

	@Override
	public Event copy() {
		return new Probe(this);
	}

}
