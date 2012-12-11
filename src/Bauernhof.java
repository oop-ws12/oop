/**
 * Instaznzen dieser Klasse stellen einen Bauernhof dar
 * Ein Bauernhof besitzt eine Menge von Traktoren und hat einen eindeutigen, 
 * unveraenderlichen Namen
 */
@Author("Alexander Prennsberger")
class Bauernhof {

	/**
	 * Eindeutige Seriennummer, welche am Ende des Namens
	 * angeheangt wird, um die Eindeutigkeit des Namens
	 * zu geweahrleisten
	 */
	private static int id = 0;
	
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
	 */
	@Author("Alexander Prennsberger")
	public Bauernhof(String name) {
		Bauernhof.id++;
		this.name = name + Bauernhof.id;
		this.traktoren = new TraktorList();	
	}
	
	/**
	 * Fuegt einen neuen Traktor auf dem Bauernhof hinzu
	 * @param t != null der neue Traktor
	 * @return true falls der Traktor hinzugefuegt wurde, false sonst
	 */
	@Author("Alexander Prennsberger")
	public boolean addTraktor(Traktor t) {
		 return traktoren.add(t);
	}
	
	/**
	 * Entfernt einen Traktor aus dem Bauernhof
	 * @param id Seriennummer des zu entfernenden Traktors
	 * @return true falls der Traktor entfernt wurde, false sonst
	 */
	@Author("Alexander Prennsberger")
	public boolean removeTraktor(int id) {
		return traktoren.remove(id);
	}
	
	/**
	 * Liefert die durchschnittliche Anzahl an Betriebsstunden aller Traktoren einer bestimmten Art
	 * Wird als Parameter null uebergeben, werden die Traktoren nicht gefiltert
	 * @param motortyp Motortyp des Traktors, nach dem gefiltert werden soll, null fuer alle
	 * @param einsatz, Einsatzzweck des Traktors, nach dem gefiltert werden soll, null fuer alle
	 * @return die durchschnittliche Anzahl an Betriebsstunden
	 * @throws IllegalArgumentException bei einer Division durch 0
	 */
	@Author("Alexander Prennsberger")
	public double getAverageBetrieb(Traktor motortyp, Einsatzzweck einsatz) throws IllegalArgumentException {

		double sum = 0;
		double anzahl = 0;
		
		ObjectList result = traktoren.filter(motortyp, einsatz);
		
		ObjectIterator it = result.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = (Traktor)it.next();
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
	 */
	@Author("Alexander Prennsberger")
	public double getAverageSpritVerbrauch(Traktor motortyp, Einsatzzweck einsatz) throws IllegalArgumentException {
	
		double sum = 0; 
		double anzahl = 0;
		
		if(motortyp == null) {
			throw new IllegalArgumentException("Spritverbauch von Biogastraktoren und Dieseltraktoren kann nicht gemeinsam berechnet werden!");
		}
				
		ObjectList result = traktoren.filter(motortyp, einsatz);
		
		ObjectIterator it = result.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = (Traktor)it.next();
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
	 */
	@Author("Alexander Prennsberger")
	public int getMinAnzahlSaeschare(Traktor motortyp) {
		
		int wert = getMaxAnzahlSaeschare(motortyp);
		ObjectList result = traktoren.filter(motortyp, new Driller(0));
		
		ObjectIterator it = result.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = (Traktor)it.next();
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
	 */
	@Author("Alexander Prennsberger")
	public int getMaxAnzahlSaeschare(Traktor motortyp) {
		
		int wert = 0;
		
		ObjectList result = traktoren.filter(motortyp, new Driller(0));
		
		ObjectIterator it = result.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = (Traktor)it.next();
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
	 */
	@Author("Alexander Prennsberger")
	public double getAverageFassung(Traktor motortyp) throws IllegalArgumentException {
		
		double sum = 0;
		double anzahl = 0;
		
		ObjectList result = traktoren.filter(motortyp, new Duenger(0));
		
		ObjectIterator it = result.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = (Traktor)it.next();
			sum += t.getEinsatzSpezDaten();
			anzahl++;
		}	
			
		if(anzahl == 0) {
			throw new IllegalArgumentException("Division durch 0: Anzahl der Traktoren gleich 0!");
		}
		return sum/anzahl;
	}
	
	/**
	 * Erhoeht die Betriebsstunden des angegebenen Traktors, falls der Traktor nicht existiert geschieht nichts
	 * @param id der Traktor
	 * @param stunden darf nicht negativ sein, die Stunden, um welche erhoeht werden sollen
	 */
	@Author("Alexander Prennsberger")
	public void erhoeheBetriebsstunden(int id, int stunden) {
		
		Traktor t = (Traktor)traktoren.get(id);
		
		if(t != null) {
			t.setBetriebsstunden(stunden);
		}
	}
	
	/**
	 * Liefert die Betriebsstunden des angegebenen Traktors
	 * @param id der Traktor
	 * @return die Betriebsstunden, und -1 falls der Traktor nicht existiert
	 */
	@Author("Alexander Prennsberger")
	public int getBetriebsstunden(int id) {
		
		Traktor t = (Traktor)traktoren.get(id);
		
		if(t != null)
			return t.getBetriebsstunden();
		
		else return -1;
	}
	
	/**
	 * Erhoeht den Spritverbrauch des angegebenen Traktors, falls der Traktor nicht existiert geschieht nichts
	 * @param id der Traktor
	 * @param sprit darf nich negativ sein, der Spritverbrauch, um welchen erhoeht werden soll
	 */
	@Author("Alexander Prennsberger")
	public void erhoeheSpritVerbrauch(int id, double sprit) {
		
		Traktor t = (Traktor)traktoren.get(id);
		
		if(t != null)
			t.setSpritVerbrauch(sprit);
	}
	
	/**
	 * Liefert den Spritverbrauch des angegebenen Traktors
	 * @param id der Traktor
	 * @return den Spritverbrauch und -1 falls der Traktor nicht existiert
	 */
	@Author("Alexander Prennsberger")
	public double getSpritVerbrauch(int id) {
		
		Traktor t = (Traktor)traktoren.get(id);
		
		if(t != null)
			return t.getSpritVerbrauch();
		
		else return -1;
	}
	
	/**
	 * Aendert die Einsatzart des angegebenen Traktors, falls der Traktor nicht existiert oder der Einsatzzweck null ist 
	 * geschieht nichts
	 * @param id der Traktor
	 * @param neu != null die neue Einsatzart
	 */
	@Author("Alexander Prennsberger")
	public void changeEinatzart(int id, Einsatzzweck neu) {
		
		Traktor t = (Traktor)traktoren.get(id);
		
		if(t != null && neu != null)
			t.changeEinsatzzweck(neu);
	}
	
	/**
	 * Liefert die Einsatzzweck spezifischen Daten des angegebenen Traktors
	 * @param id der Traktor
	 * @return spezifische Einsatzdaten, -1 falls der Traktor nicht existiert
	 */
 	@Author("Alexander Prennsberger")
	public double getDaten(int id) {
		
		Traktor t = (Traktor)traktoren.get(id);
		
		if(t != null)
			return t.getEinsatzSpezDaten();
		
		else return -1;
	}

	/**
	 * @return den Namen des Bauernhofs
	 */
 	@Author("Alexander Prennsberger")
	public String getName() {
		return name;
	}
 	
 	/**
 	 * @return eine neue TraktorList mit allen Traktoren des Bauernhofs
 	 */
 	@Author("Alexander Prennsberger")
 	public TraktorList getTraktorList() {
 		
 		TraktorList result = new TraktorList();
 		
 		ObjectIterator it = traktoren.iterator();
 		
 		while(it.hasNext()) {
 			
 			result.add((Traktor) it.next());
 		}
 		return result;
 	}
	
	/**
	 * @return eine lesbare Form des Bauernhofs
	 */
 	@Author("Alexander Prennsberger")
	public String toString() {
		
		String result = name + "\n";
		
		ObjectIterator it = traktoren.iterator();
		
		while(it.hasNext()) {
			
			Traktor t = (Traktor)it.next();
			result += t.toString() + "\n";
		}
		return result;
	}	
}
