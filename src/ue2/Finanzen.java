
import java.math.BigDecimal;
import java.util.Date;

/**
 * Eigenschaft, dass das Objekt sich um eine Finanz handelt
 * und mit einem Zahlenwert beschrieben werden kann.
 *
 */

public interface Finanzen {
	
	public BigDecimal getWert();
	
	/**
	 * Gibt zurueck, um welche Art der Finanz sich es handelt (Kosten/Einnahmen)
	 * @return
	 */
	public String getArt();
	
	/**
	 * Gibt das Faelligkeitsdatum der Finanz zurueck
	 * @return 
	 */
	public Date getZeitpunkt();
}
