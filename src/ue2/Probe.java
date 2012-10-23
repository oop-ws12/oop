package ue2;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Stellt eine Probe der MusikGruppe dar.
 */
public class Probe extends Event {
	
	private BigDecimal raumMiete;

	public Probe(Ort ort, Date beginn, Date end, BigDecimal raumMiete) {
		super(ort, beginn, end);
		this.raumMiete = raumMiete;
	}

	public Probe(Probe o) {
		super(o);
		this.raumMiete = o.raumMiete;
	}

	public BigDecimal getRaumMiete() {
		return raumMiete;
	}

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
