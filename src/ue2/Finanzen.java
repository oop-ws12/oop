package ue2;

import java.math.BigDecimal;
import java.util.Date;

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
