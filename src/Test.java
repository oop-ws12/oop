import java.lang.reflect.Method;

public class Test {
	
	private static int tests = 0;
	private static int success = 0;

	public static void main(String[] args) {
	

		testBauernhof();
		testStatistiken();
		testAnnotation();
		
		System.out.println(String.format("%s/%s Tests erfolgreich!", success, tests));
	}
	
	private static BauernhofList testBauernhof() {
		
		BauernhofList hoefe = createBauernhoefe();
		
		Driller d1 = new Driller(25);
		Driller d2 = new Driller(50);
		Driller d3 = new Driller(88);
		
		Duenger u1 = new Duenger(20.2);
		Duenger u2 = new Duenger(42.8);
		Duenger u3 = new Duenger(55.5);
		
		ObjectIterator it = hoefe.iterator();
	
		for(int i = 0; i < hoefe.size(); i++) {
			
			Bauernhof b = (Bauernhof) it.next();
			Bauernhof a = (Bauernhof) hoefe.get(b.getName());
			
			ok(a.equals(b));
			
			ObjectIterator ot = a.getTraktorList().iterator();
			
			for(int j = 0; j < 5; j++) {
				
				Traktor t = (Traktor) ot.next();
				
				a.changeEinatzart(t.getSerial(), d1);
			}
			for(int k = 0; k < 5; k++) {
				
				Traktor t = (Traktor) ot.next();
				
				a.changeEinatzart(t.getSerial(), u1);
			}
		}
		
		DieselTraktor t1 = new DieselTraktor();
		DieselTraktor t2 = new DieselTraktor();
		BiogasTraktor t3 = new BiogasTraktor();
		BiogasTraktor t4 = new BiogasTraktor();
		
		t1.changeEinsatzzweck(d2);
		t2.changeEinsatzzweck(u2);
		t3.changeEinsatzzweck(d3);
		t4.changeEinsatzzweck(u3);
		
		it = hoefe.iterator();
		
		for(int i = 0; i < hoefe.size(); i++) {
			
			Bauernhof b = (Bauernhof) it.next();
			
			b.addTraktor(t1);
			b.addTraktor(t2);
			b.addTraktor(t3);
			b.addTraktor(t4);
	
		}
		
		it = hoefe.iterator();
		
		while(it.hasNext()) {
			
			Bauernhof b = (Bauernhof) it.next();
			
			ok(b.getTraktorList().size() == 14);
		}
		
		it = hoefe.iterator();
		
		for(int i = 0; i < hoefe.size(); i++) {
			
			Bauernhof b = (Bauernhof) it.next();
			
			b.removeTraktor(t1.getSerial());
			b.removeTraktor(t2.getSerial());
			b.removeTraktor(t3.getSerial());
			b.removeTraktor(t4.getSerial());
		}
		
		it = hoefe.iterator();
		
		while(it.hasNext()) {
			
			Bauernhof b = (Bauernhof) it.next();
			
			ok(b.getTraktorList().size() == 10);
		}
		
		it = hoefe.iterator();
		
		for(int i = 0; i < hoefe.size(); i++) {
			
			Bauernhof b = (Bauernhof) it.next();
			
			b.addTraktor(t1);
			b.addTraktor(t2);
			b.addTraktor(t3);
			b.addTraktor(t4);
			
			ObjectIterator ot = b.getTraktorList().iterator();
			
			while(ot.hasNext()) {
				
				Traktor t = (Traktor) ot.next();
				
				b.erhoeheBetriebsstunden(t.getSerial(), 230);
				b.erhoeheSpritVerbrauch(t.getSerial(), 49.80);
			}	
		}
		
		return hoefe;
	}
	
	private static void testStatistiken() {
		
		BauernhofList hoefe = testBauernhof();
		
		ObjectIterator it = hoefe.iterator();
		
		Bauernhof b = (Bauernhof) it.next();
		
		DieselTraktor t1 = new DieselTraktor();
		BiogasTraktor t2 = new BiogasTraktor();
		
		Driller d1 = new Driller(0);
		Duenger d2 = new Duenger(0);
		
		b.addTraktor(t1);
		
		ok(b.getAverageBetrieb(t1, d1) == 431.25);
		
		ok(b.getAverageBetrieb(t1, d2) == 492.85714285714283 );

		ok(b.getAverageBetrieb(null, null) == 460.0);
		
		//Alle Werte gleich, da gleich viele DieselTraktoren und BiogasTraktoren im 
		//Bauernhof sind und alle die gleiche Kapaziteat haben
		ok(b.getAverageFassung(t1) == 28.47142857142857);
		ok(b.getAverageFassung(t2) == 28.47142857142857);
		ok(b.getAverageFassung(null) == 28.47142857142857);
		
		ok(b.getAverageSpritVerbrauch(t1, d1) == 93.575);
		ok(b.getAverageSpritVerbrauch(t1, d2) == 106.91428571428571);
		ok(b.getAverageSpritVerbrauch(t2, d1) == 93.575);
		ok(b.getAverageSpritVerbrauch(t1, null) == 93.75);
		
		ok(b.getMaxAnzahlSaeschare(t1) == 88);
		ok(b.getMinAnzahlSaeschare(t1) == 0);
	}

	private static void testAnnotation() {
			
		Method[] as = Bauernhof.class.getMethods();
		
		for(Method m : as) {
			
			Author a = m.getAnnotation(Author.class);
			if(a != null) {
				System.out.println(m.getName() + " von " + a.value());
			}
		}	
		
		Method[] bs = Traktor.class.getMethods();
		
		for(Method m : bs) {
			
			Author a = m.getAnnotation(Author.class);
			if(a != null) {
				System.out.println(m.getName() + " von " + a.value());
			}
		}	
	}
	
	private static BauernhofList createBauernhoefe() {
		
		BauernhofList list = new BauernhofList();
		
		for(int i = 0; i < 5; i++) {
			
			Bauernhof b = new Bauernhof("Hof");
			
			list.add((Bauernhof) b);
			
			for(int j = 0; j < 5; j++) {
				b.addTraktor(new DieselTraktor());
				b.addTraktor(new BiogasTraktor());
			}	
		}
		return list;
	}

	/**
	 * Prueft zwei Objekte auf Gleichheit
	 * @param o1 Objekt 1
	 * @param o2 Objekt 2
	 */
	private static void  eq(Object o1, Object o2) {
	
		if(!o1.equals(o2)) {
			throw new RuntimeException(String.format("%s != %s", o1, o2));
		}
		else success++;
	}
	
	/**
	 * Prueft ob die uebergebene Bedinung wahr ist
	 * @param cond die Bedingung, die geprueft wird
	 */
	private static void ok(boolean cond) {
		tests++;
		eq(true, cond);
	}

}
