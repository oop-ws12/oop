import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class AusgelieferteAndroiden {
	public static class AusgelieferterAndroid<A extends Android> {
		private A android;
		private Skin skin;
		private Software<A> software;
		private SensorAktorKit kit;
		/**
		 * @return the android
		 */
		public A getAndroid() {
			return android;
		}
		
		/**
		 * @return the skin
		 */
		public Skin getSkin() {
			return skin;
		}
		
		/**
		 * @return the software
		 */
		public Software<A> getSoftware() {
			return software;
		}
		
		/**
		 * @return the kit
		 */
		public SensorAktorKit getKit() {
			return kit;
		}
		
		public <T extends Software<A>&AndroidVerordnung> AusgelieferterAndroid(A android, Skin skin, SensorAktorKit kit,
				T software) {
			this.android = android;
			this.skin = skin;
			this.kit = kit;
			this.software = software;
		}
		
		public boolean validate() {
			return skin.validate(android) && kit.validate(android, software) && software.validate(android);
 		}
		
		@Override
		public String toString() {
			return skin.toString() + kit.toString();
		}
	}
	
	private ArrayList<AusgelieferterAndroid<?>> list = new ArrayList<AusgelieferteAndroiden.AusgelieferterAndroid<?>>();
	
	/**
	 * Fuegt einen Androiden mit eindeutiger Seriennummer und allen Ausstattungsdetails in die Liste ein 
	 * und prueft die Bedingungen der Androide-Verordnung. Sind die Bedingungen nicht erfuellt, bleibt die 
	 * Liste unveraendert, und false wird zurueckgegeben. 
	 * Kommt ein Androide mit derselben Seriennummer bereits in der Liste vor, so handelt es sich um eine 
	 * Aenderung, sonst um die Auslieferung eines neuen Androiden. Als Ausstattungsdetails bekommt jeder 
	 * Android ein Sensoren-Aktoren-Kit, eine Skin und eine Software mit.
	 * @return true falls erfolgreich hinzugefuegt/aktualisiert
	 */
	public <A extends Android, S extends Software<A>&AndroidVerordnung> boolean insert(
			A android, 
			Skin skin, 
			SensorAktorKit kit, 
			S software) 
	{
		final AusgelieferterAndroid<A> a = new AusgelieferterAndroid<A>(android, skin, kit, software);
	
		return new Conditional(a.validate()).foldTrue(new Conditional.Action<Boolean>() {
			@Override
			public Boolean map() {
				ListIterator<AusgelieferterAndroid<?>> it = list.listIterator();
				boolean updated = false;
				
				while(it.hasNext()) {
					AusgelieferterAndroid<?> item = it.next();
					if(item.getAndroid().getSerial().equals(a.getAndroid().getSerial())) {
						it.remove();
						it.add(a);
						updated = true;
					}
				}
				
				new Conditional(updated).foldFalse(new Conditional.Action<Boolean>() {
					@Override
					public Boolean map() {
						return list.add(a);
					}
				});
				
				return true;
			}
		});
	}
	
	/**
	 * Liefert einen String mit der Beschreibung aller Ausstattungsdetails des Androiden mit der als 
	 * Parameter gegebenen Seriennummer zurueck (oder null falls kein Androide mit dieser Seriennummer existiert).
	 * @param serialNr
	 * @return
	 */
	public String find(String serialNr) {
		for(AusgelieferterAndroid<?> a : list) {
			if(a.getAndroid().getSerial().equals(serialNr)) {
				return a.toString();
			}
		}
		
		return null;
	}
	
	/**
	 * Erzeugt einen Iterator ueber den ausgelieferten Androiden in der Reihenfolge der ersten Auslieferung 
	 * (das ist die Reihenfolge des Einfuegens neuer Androiden).
	 * @return
	 */
	public Iterator<AusgelieferterAndroid<?>> iterator() {
		return list.iterator();
	}
}
