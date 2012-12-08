/**
 * Instaznzen dieser Klasse stellen einen Bauernhof dar
 * Ein Bauernhof besitzt eine Menge von Traktoren und hat einen eindeutigen, 
 * unveraenderlichen Namen
 * @author Alexander Prennsberger
 */
public class Bauernhof {

	/**
	 * Eindeutige Seriennummer, welche am Ende des Namens
	 * angeheangt wird, um die Eindeutigkeit des Namens
	 * zu geweahrleisten
	 */
	private static int id;
	
	/**
	 * Der eindeutige Name des Bauernhofs,
	 * ist nach dem initialisieren unveraenderlich
	 */
	private final String name;
	
	/**
	 * Beinhaltet alle Traktoren des Bauernhofs
	 */
	private TraktorList traktoren;
	
	/**
	 * Initialisiert einen neuen Bauernhof mit dem uebergebenen Namen + einer einzigartigen id
	 * @param name an ihn wird noch eine eindeutige ID angehaengt
	 * @author Alexander Prennsberger
	 */
	public Bauernhof(String name) {
		id++;
		this.name = name + id;
		this.traktoren = new TraktorList();	
	}
	
	/**
	 * Fuegt einen neuen Traktor auf dem Bauernhof hinzu
	 * @param t != null der neue Traktor
	 * @return true falls der Traktor hinzugefuegt wurde, false sonst
	 * @author Alexander Prennsberger
	 */
	protected boolean addTraktor(Traktor t) {
		 return traktoren.add(t);
	}
	
	/**
	 * Entfernt einen Traktor aus dem Bauernhof
	 * @param id Seriennummer des zu entfernenden Traktors
	 * @return true falls der Traktor entfernt wurde, false sonst
	 * @author Alexander Prennsberger
	 */
	protected boolean removeTraktor(int id) {
		return traktoren.remove(id);
	}
	
	/**
	 * Liefert die durchschnittliche Anzahl an Betriebsstunden aller Traktoren einer bestimmten Art
	 * Wird als Parameter null uebergeben, werden die Traktoren nicht gefiltert
	 * @param motortyp Motortyp des Traktors, nach dem gefiltert werden soll, null fuer alle
	 * @param einsatz, Einsatzzweck des Traktors, nach dem gefiltert werden soll, null fuer alle
	 * @return die durchschnittliche Anzahl an Betriebsstunden
	 * @throws IllegalArgumentException bei einer Division durch 0
	 * @author Alexander Prennsberger
	 */
	protected double getAverageBetrieb(Traktor motortyp, Einsatzzweck einsatz) throws IllegalArgumentException {

		double sum = 0;
		double anzahl = 0;
		
		TraktorList result = traktoren.filter(motortyp, einsatz);
		
		for(Traktor t : result) {	
			sum += t.getBetriebsstunden();
			anzahl++;
		}
		
		if (anzahl == 0) {
			throw new IllegalArgumentException("Division durch 0: Anzahl der Traktoren ist 0!");
		}
		return sum/anzahl;
	}
	
	/**
	 * Liefert den durchschnittlichen Spritverbrauch der Traktoren am Bauernhof
	 * @param motortyp != null Motortyp des Traktors, nach dem gefiltert werden soll
	 * @param einsatz, Einsatzzweck des Traktors, nach dem gefiltert werden soll, null fuer alle
	 * @return den durchschnittlichen Dieselverbrauch
	 * @throws IllegalArgumentException bei Division durch 0 und falls motortyp == null
	 * @author Alexander Prennsberger
	 */
	protected double getAverageSpritVerbrauch(Traktor motortyp, Einsatzzweck einsatz) throws IllegalArgumentException {
	
		double sum = 0; 
		double anzahl = 0;
		
		if(motortyp == null) {
			throw new IllegalArgumentException("Spritverbauch von Biogastraktoren und Dieseltraktoren kann nicht gemeinsam berechnet werden!");
		}
				
		TraktorList result = traktoren.filter(motortyp, einsatz);
		
		for(Traktor t : result) {
		
			sum += t.getSpritVerbrauch();
			anzahl++;	
		}
		
		if (anzahl == 0) {
			throw new IllegalArgumentException("Division durch 0: Anzahl der Traktoren ist 0!");
		}
		return sum/anzahl;
	}
	
	/**
	 * Liefert die minimale Anzahl an Saescharen insgesamt
	 * oder gefiltert nach Motortyp, am gesamten Bauernhof
	 * @param motortyp Motortyp nach dem gefiltert werden soll, null fuer alle
	 * @return die minimale Anazahl der Saescharen am Bauernhof
	 * @author Alexander Prennsberger
	 */
	protected int getMinAnzahlSaeschare(Traktor motortyp) {
		
		int wert = 0;
		TraktorList result = traktoren.filter(motortyp, new Driller(0));
		
		wert = getMaxAnzahlSaeschare(motortyp);
			
		for(Traktor t : result) {
				
			int temp = (int)t.getEinsatzSpezDaten();
				
			if(temp < wert) {
				wert = temp;
			}
		}
		return wert;
	}
	
	/**
	 * Liefert die maximale Anzahl an Saescharen insgesamt
	 * oder gefiltert nach Motortyp, am gesamten Bauernhof
	 * @param motortyp Motortyp nach dem gefiltert werden soll, null fuer alle
	 * @return die maximale Anazahl der Saescharen am Bauernhof
	 * @author Alexander Prennsberger
	 */
	protected int getMaxAnzahlSaeschare(Traktor motortyp) {
		
		int wert = 0;
		
		TraktorList result = traktoren.filter(motortyp, new Driller(0));
		
		for(Traktor t : result) {
			
			int temp = (int)t.getEinsatzSpezDaten();
			
			if(temp > wert) {
				wert = temp;
			}
		}	
		return wert;
	}
	
	/**
	 * Liefert die durchnittliche Fassungskapaziteat aller Duengstreuer am Bauernhof
	 * Es kann nach Motortyp gefiltert werden
	 * @param motortyp Motortyp, nach dem gefiltert werden soll, null fuer alle
	 * @return die durschnittliche Fassungskapaziteat der Duengstreuer
	 * @throws IllegalArgumentException bei Division durch 0
	 * @author Alexander Prennsberger
	 */
	protected double getAverageFassung(Traktor motortyp) throws IllegalArgumentException {
		
		double sum = 0;
		double anzahl = 0;
		
		TraktorList result = traktoren.filter(motortyp, new Duenger(0));
		
		for(Traktor t : result) {
			
			sum += t.getEinsatzSpezDaten();
			anzahl++;
		}
		
		if(anzahl == 0) {
			throw new IllegalArgumentException("Division durch 0: Anzahl der Traktoren gleich 0!");
		}
		return sum/anzahl;
	}
	
	/**
	 * Erhoeht die Betriebsstunden des angegebenen Traktors
	 * @param id der Traktor
	 * @param stunden darf nicht negativ sein, die Stunden, um welche erhoeht werden sollen
	 * @author Alexander Prennsberger
	 */
	protected void erhoeheBetriebsstunden(int id, int stunden) {
		traktoren.get(id).setBetriebsstunden(stunden);
	}
	
	/**
	 * Liefert die Betriebsstunden des angegebenen Traktors
	 * @param id der Traktor
	 * @return die Betriebsstunden
	 * @author Alexander Prennsberger
	 */
	protected int getBetriebsstunden(int id) {
		return traktoren.get(id).getBetriebsstunden();
	}
	
	/**
	 * Erhoeht den Spritverbrauch des angegebenen Traktors
	 * @param id der Traktor
	 * @param sprit darf nich negativ sein, der Spritverbrauch, um welchen erhoeht werden soll
	 * @author Alexander Prennsberger
	 */
	protected void erhoeheSpritVerbrauch(int id, double sprit) {
		traktoren.get(id).setSpritVerbrauch(sprit);
	}
	
	/**
	 * Liefert den Spritverbrauch des angegebenen Traktors
	 * @param id der Traktor
	 * @return den Spritverbrauch
	 * @author Alexander Prennsberger
	 */
	protected double getSpritVerbrauch(int id) {
		return traktoren.get(id).getSpritVerbrauch();
	}
	
	/**
	 * Aendert die Einsatzart des angegebenen Traktors
	 * @param id der Traktor
	 * @param neu != null die neue Einsatzart
	 * @author Alexander Prennsberger
	 */
	protected void changeEinatzart(int id, Einsatzzweck neu) {
		traktoren.get(id).changeEinsatzzweck(neu);
	}
	
	/**
	 * Liefert die Einsatzzweck spezifischen Daten des angegebenen Traktors
	 * @param id der Traktor
	 * @return spezifische Einsatzdaten
	 * @author Alexander Prennsberger
	 */
	protected double getDaten(int id) {
		return traktoren.get(id).getEinsatzSpezDaten();
	}

	
	/**
	 * @return den Namen des Bauernhofs
	 * @author Alexander Prennsberger
	 */
	protected String getName() {
		return name;
	}
	
	/**
	 * @return eine lesbare Form des Bauernhofs
	 * @author Alexander Prennsberger
	 */
	public String toString() {
		
		String result = name + "\n";
		
		for(Traktor T : traktoren) {	
			result += T.toString() + "\n";
		}	
		return result;
	}
	
	
}
