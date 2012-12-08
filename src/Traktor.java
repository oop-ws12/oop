/**
 * Instanzen dieser Klasse stellen einen Traktor dar
 * Jeder Traktor bestitzt eine eindeutige, unveraenderliche Seriennummer
 * @author Alexander Prennsberger
 */
public abstract class Traktor implements Filter<Traktor> {
	
	private static int serial;
	
	/**
	 * Eindeutige Seriennummer des Traktors
	 * Nachdem die Nummer gesetzt wurde, ist sie unveraenderlich
	 */
	private int id;
	
	/**
	 * Enthaelt die Betriebsstunden des Traktors
	 * Am Anfang sind die Betriebsstunden gleich 0
	 * Darf nicht negativ sein
	 */
	private int inBetrieb = 0;
	
	/**
	 * Enthaelt den Einsatzzweck des Traktors
	 * Entweder Saen oder Duengen
	 */
	private Einsatzzweck zweck;
	
	/**
	 * Initialisiert einen neuen Traktor, weist ihm eine eindeutige Seriennummer zu
	 * und einem Standardmaessigen Einsatzzweck als Driller
	 * @author Alexander Prennsberger
	 */
	public Traktor() {
		this.id = serial++;	
		zweck = new Driller(0);
	}
	
	/**
	 * Liefert die Anzahl der Stunden, welche der Traktor schon in Betrieb ist
	 * @return die Anzahl der Betriebsstunden
	 * @author Alexander Prennsberger
	 */
	protected int getBetriebsstunden() {
		return inBetrieb;
	}
	
	/**
	 * Erhoeht die Betriebsstunden des Traktors um den uebergebenen Wert
	 * @param stunden darf nicht negativ sein
	 * @author Alexander Prennsberger
	 */
	protected void setBetriebsstunden(int stunden) {
		this.inBetrieb += stunden;
	}
	
	/**
	 * @return die Seriennummer des Traktors
	 * @author Alexander Prennsberger
	 */
	protected int getSerial() {
		return id;
	}
	
	/**
	 * Aendert den Einsatzzweck des Traktors
	 * Dabei gehen Informationen ueber fruehere Einsatzzwecke verloren
	 * @param neu neuer Einsatzzweck des Traktors, neu != null
	 * @author Alexander Prennsberger
	 */
	protected void changeEinsatzzweck(Einsatzzweck neu) {
		this.zweck = neu;
	}
	
	/**
	 * @return den Einsatzzweck des Traktors
	 * @author Alexander Prennsberger
	 */
	protected Einsatzzweck getEinsatzzweck() {
		return zweck;
	}
	
	/**
	 * Liefert die dem Einsatzzweck ensprechenden Daten des Traktors
	 * @return entweder die Anzahl der Saeschare bei einer Drillmaschine oder die Fassungskapaziteat
	 * bei einem Duengstreuer
	 * @author Alexander Prennsberger
	 */
	protected double getEinsatzSpezDaten() {
		return zweck.getDaten();
	}
	
	/**
	 * @return den Spritverbrauch des Traktors seit Betriebsbeginn
	 * @author Alexander Prennsberger
	 */
	protected abstract double getSpritVerbrauch();
	
	
	/**
	 * Erhoeht den Spritverbrauch des Traktors um den uebergebenen Wert
	 * @param sprit darf nicht negativ sein
	 * @author Alexander Prennsberger
	 */
	protected abstract void setSpritVerbrauch(double sprit);
	
	/**
	 * @return eine lesbare Form des Traktors
	 * @author Alexander Prennsberger
	 */
	public String toString() {
		
		String result = "Seriennummer: " + id + "\n"
				      + "Betriebsstunden: " + inBetrieb + "\n"
				      + "Verwendungszweck: " + zweck + "\n";
		
		return result;	          
	}
}
