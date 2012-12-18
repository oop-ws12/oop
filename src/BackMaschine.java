/**
 * Stellt eine Backmaschine die eine bestimmte Art von Keks baeckt dar.
 */
interface BackMaschine<K extends Keks> {
    /**
     * Baeckt einen Keks aus einer Vorlage
     * @param vorlage die Vorlage
     * @return den gebackten Keks
     */
    K backe(K vorlage);
}
