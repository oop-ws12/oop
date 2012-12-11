public class Test {
	
	private static int tests = 0;
	private static int success = 0;

	public static void main(String[] args) {
	
		//test1();
		testBauernhof();
		
		System.out.println(String.format("%s/%s Tests erfolgreich!", success, tests));
	}
	
	private static void test1() {
		
		Driller d1 = new Driller(10);
		Driller d2 = new Driller(20);
		
		Duenger d3 = new Duenger(12.5);
		Duenger d4 = new Duenger(20.2);
		
		DieselTraktor t1 = new DieselTraktor();
		DieselTraktor t5 = new DieselTraktor();
		BiogasTraktor t2 = new BiogasTraktor();
		BiogasTraktor t3 = new BiogasTraktor();
		
		t1.changeEinsatzzweck(d1);
		t2.changeEinsatzzweck(d4);
		
		t1.setBetriebsstunden(20);
		t2.setBetriebsstunden(380);

		t1.changeEinsatzzweck(d3);
		t2.changeEinsatzzweck(d2);

	
	
		t3.setBetriebsstunden(500);
		
		Bauernhof b1 = new Bauernhof("EdisHof");

		b1.addTraktor(t1);
		b1.addTraktor(t2);
		b1.addTraktor(t3);
		b1.addTraktor(t5);
		
		Traktor T = new BiogasTraktor();
		b1.addTraktor(T);

		b1.erhoeheSpritVerbrauch(t1.getSerial(),200);
		b1.erhoeheSpritVerbrauch(t5.getSerial(),240);

	
		b1.removeTraktor(4);
		b1.removeTraktor(2);
		
		System.out.println(b1);
		System.out.println("Anzahl der durchschn. Betriebsstunden von Duengstreuer: " + b1.getAverageBetrieb(null, d1));
		ok(b1.getAverageBetrieb(null, d1) == 250.0);
		System.out.println("Anzahl des durchschn. DieselVerbauch von Duengstreuer: " + b1.getAverageSpritVerbrauch(t1,d3));
		System.out.println("Anzahl des durchschn. DieselVerbauch von Duengstreuer: " + b1.getMinAnzahlSaeschare(null));
		System.out.println("Anzahl des durchschn. DieselVerbauch von Duengstreuer: " + b1.getMaxAnzahlSaeschare(null));
	}
	
	private static void testBauernhof() {
		
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
