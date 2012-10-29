
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * Stellt sonstige Einnahmen oder Kosten dar
 * 
 */
public class AllgemeinFinanzen implements Finanzen {

	private Date zeitpunkt;
	private BigDecimal wert;
	private String art;
	
	/**
	 * Initialisiert die AllgemeinFinanz
	 * 
	 * @param zeitpunkt != null, Faelligkeit
	 * @param wert != null
	 * @param art != null
	 */
	public AllgemeinFinanzen(Date zeitpunkt, BigDecimal wert, String art) {

		this.zeitpunkt = zeitpunkt;
		this.wert = wert;
		this.art = art;
	}

	@Override
	public BigDecimal getWert() {
		return wert;
	}

	@Override
	public String getArt() {

		return art;
	}

	@Override
	public Date getZeitpunkt() {

		return zeitpunkt;
	}

}
