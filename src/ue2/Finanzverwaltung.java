
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Stellt eine Liste von Finanzen (Kosten/Einnahmen) dar
 * und bietet Moeglichkeiten zur Verwaltung dieser (aufsummieren)
 */
public class Finanzverwaltung extends ArrayList<Finanzen> {

	private static final long serialVersionUID = 3416147856287519204L;
	private static final String noFilter = "ALL";

	/**
	 * Berechnet die Gesamtkosten/Gewinn des gegebenen Zeitraumes aller
	 * Finanzen.
	 * 
	 * @param begin != null
	 * @param end != null && end > begin
	 * @return Gesamtkosten/Gewinn
	 */
	public BigDecimal summe(Date begin, Date end) {

		return summe(begin, end, Event.class).add(summe(begin, end, noFilter));
	}

	/**
	 * Berechnet die Gesamtkosten/Gewinn des gegebenen Zeitraumes fuer Events
	 * 
	 * @param begin != null
	 * @param end != null && end > begin
	 * @param type != null, Type muss vom Typ Event sein Filter, Welche Finanzart aufsummiert werden soll
	 * @return Gesamtkosten/Gewinn
	 */
	public BigDecimal summe(Date begin, Date end, Class<? extends Event> type) {

		BigDecimal summe = new BigDecimal(0);

		for (Finanzen f : this) {

			if (type.isAssignableFrom(f.getClass())) {

				Event e = (Event) f;

				boolean zeitraum = begin.compareTo(e.getEnde()) <= 0
						&& e.getBeginn().compareTo(end) <= 0;

				if (zeitraum) {
					summe = summe.add(e.getWert());
				}
			}
		}
		return summe;
	}

	/**
	 * SCHLECHT: Muss bei der Berechnung der AllgemeinFinanzen
	 * extra noch die Events ausschliessen.
	 * Besser waere nur eine Methode zur Berechnung aller Finanzen mit 
	 * einem bestimmten Filter.
	 * 
	 * Berechnet die Gesamtkosten/Gewinn fuer bestimmte Allgemeinfinanzen
	 * 
	 * @param begin != null
	 * @param end != null && end > begin
	 * @param art
	 *            Filter fuer aufsummieren bestimmter Allgemeinfinanzen, "all"
	 *            fuer alle
	 * @return BigDecimal Ergebnis der Summierung
	 */
	public BigDecimal summe(Date begin, Date end, String art) {

		BigDecimal summe = new BigDecimal(0);

		for (Finanzen e : this) {

			boolean zeitraum = e.getZeitpunkt().compareTo(begin) >= 0
					&& e.getZeitpunkt().compareTo(end) <= 0;

			// Summiere alle Finanzen ausser Events
			if (art.equals(noFilter) && e.getClass() != Auftritt.class
					&& e.getClass() != Probe.class) {
				if (zeitraum)
					summe = summe.add(e.getWert());
			}

			else if (e.getArt().equals(art) && zeitraum) {
				summe = summe.add(e.getWert());
			}
		}

		return summe;
	}

}
