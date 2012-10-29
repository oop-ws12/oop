
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * Stellt einen Auftritt der Musikgruppe dar.
 * 
 */
public class Auftritt extends Event {

	private BigDecimal gage;

	/**
	 * Initialisiert eine Auftritt
	 * 
	 * @param gage != null
	 * @param setup Zusammensetzung der Mitglieder, die am Auftritt teilnehmen
	 * @param probeAnfang != null Anfang des Zeitraums in welchem die Anzhahl der Probenteilnahmen geprueft wird
	 * @param probeEnde != null && probeEnde > probeAnfang  Ende des Zeitraums fuer Probenteilnahmen
	 * @param anzahlAnProben Mitglied muss gewisse Anzahl an Proben in definiertem Zeitraum absolviert haben
	 * @throws GesperrtException, falls Mitglied fuer den Auftritt gesperrt ist
	 */
	public Auftritt(Ort ort, Date beginn, Date end, BigDecimal gage,
			Collection<Mitglied> setup, Date probeAnfang, Date probeEnde,
			int anzahlAnProben) throws GesperrtException {
		super(ort, beginn, end, setup);
		this.gage = gage;

		for (Mitglied m : setup) {

			if (m.istErsatz()) {

				if (!m.hatProbenBesucht(probeAnfang, probeEnde, anzahlAnProben)) {
					m.setGesperrt(true);
				}
			}

			if (m.istGesperrt())
				throw new GesperrtException(m);
		}
	}
	
	/**
	 * Kopiert einen uebergebenen Auftritt
	 * @param o != null, zu kopierender Auftritt
	 */
	public Auftritt(Auftritt o) {
		super(o);
		this.gage = o.gage;
	}

	public BigDecimal getGage() {
		return gage;
	}
	
	/**
	 * Setzt die Gage
	 * @param gage != null
	 */
	public void setGage(BigDecimal gage) {
		this.observers.before(changed);
		this.gage = gage;
		this.observers.fire(changed);
	}

	@Override
	public BigDecimal getWert() {
		return gage;
	}

	@Override
	public String toString() {
		return "Auftritt [gage=" + getGage() + ", ort=" + getOrt() + "]";
	}

	@Override
	public Event copy() {
		return new Auftritt(this);
	}
}
