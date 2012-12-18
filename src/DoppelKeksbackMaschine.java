/**
 * Instanzen dieser Klasse stellen eine Kecksbackmaschine dar, 
 * welche nur Doppelkekse backen kann
 */
class DoppelKeksbackMaschine
        implements BackMaschine<DoppelKeks> {
    
	/**
	 * Backt einen neuen Doppelkeks und gibt ihn zurueck
	 * @param vorlage != null, die Vorlage nach der gebacken wird
	 */
	public DoppelKeks backe(DoppelKeks vorlage) {
        return new DoppelKeks(vorlage);
    }
}