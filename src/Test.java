import java.util.Iterator;

public class Test {
	
	public static int tests = 0;
	public static int success = 0;
	
	static class GesellschafterSoftwareSS1 extends Gesellschafter.BasicSoftware {
		@Override
		public int getStufe() {
			return 1;
		}
	}
	
	static class HilfskraftSoftwareSS1 extends Hilfskraft.BasicSoftware {
		@Override
		public int getStufe() {
			return 1;
		}
	}
	
	static class BedienerSoftwareSS2 extends Bediener.BasicSoftware {
		@Override
		public int getStufe() {
			return 2;
		}
	}
	
	static class KaempferSoftwareSS5 extends Kaempfer.BasicSoftware {
		@Override
		public int getStufe() {
			return 5;
		}
	}
	
	static class KaempferSoftwareSS4 extends Kaempfer.BasicSoftware {
		@Override
		public int getStufe() {
			return 4;
		}
	}
	
	static class LeibwaechterSoftwareSS4 extends Leibwaechter.BasicSoftware {
		@Override
		public int getStufe() {
			return 4;
		}
	}
	
	static class BauarbeiterSoftwareSS3 extends Bauarbeiter.BasicSoftware {
		@Override
		public int getStufe() {
			return 3;
		}
	}
	
	static class ServicetechnikerSoftwareSS3 extends Servicetechniker.BasicSoftware {
		@Override
		public int getStufe() {
			return 3;
		}
	}
	
	static class TransportarbeiterSoftwareSS4 extends Transportarbeiter.BasicSoftware {
		@Override
		public int getStufe() {
			return 4;
		}
	}
	
	static class TransportarbeiterSoftwareSS3 extends Transportarbeiter.BasicSoftware {
		@Override
		public int getStufe() {
			return 3;
		}
	}
	
	static class ObjektbewacherSoftwareSS5 extends Objektbewacher.BasicSoftware {
		@Override
		public int getStufe() {
			return 5;
		}
	}
	
	public static void main(String[] args) {
		
		testSkins();
		testAuslieferungsListe();
	
		System.out.println(String.format("%s/%s", success, tests) + " tests ok! :-)");
	}
	
	public static void testAuslieferungsListe() {
		
		AusgelieferteAndroiden protokoll = new AusgelieferteAndroiden();
		
		//Kit fuer Androiden mit SoftwareStufe 3 mit 4.5kW
		SensorAktorKit kit1 = new SensorAktorKit();
		
		kit1.add(new Sensor("Temp"));
		kit1.add(new Aktor("Laser", 4.0));
		kit1.add(new Sensor("Druck"));
		kit1.add(new Aktor("iwas", 0.5));
		
		//Kit fuer Bediener mit 1kW
		SensorAktorKit kit2 = new SensorAktorKit();
		
		kit2.add(new Sensor("s1"));
		kit2.add(new Aktor("ak1", 0.3));
		kit2.add(new Aktor("ak2", 0.5));
		kit2.add(new Aktor("ak3", 0.2));
		
		//Kit fuer androiden mit SoftwareStufe 4 mit 9.7kW
		SensorAktorKit kit3 = new SensorAktorKit();
		
		kit3.add(new Aktor("ak4", 6.4));
		kit3.add(new Aktor("ak5", 2.8));
		kit3.add(new Aktor("ak6", 0.5));
		
		//Kit fuer Kaempfer mit 32.7 kW
		SensorAktorKit kit4 = new SensorAktorKit();
		
		kit4.add(new Aktor("ak7", 10.5));
		kit4.add(new Aktor("ak8", 22.2));
		
		//Skins erzeugen
		BehruerungssenstiverSkin behr = new BehruerungssenstiverSkin();
		HochfesterSkin hochf = new HochfesterSkin();
		GepanzerterSkin gep = new GepanzerterSkin();
		
		//Androiden erzeugen
		Kaempfer k1 = new Kaempfer();
		Gesellschafter g1 = new Gesellschafter();
		Leibwaechter l1 = new Leibwaechter();
		Bauarbeiter b1 = new Bauarbeiter();
		Objektbewacher o1 = new Objektbewacher();
		Servicetechniker s1 = new Servicetechniker();
		Hilfskraft h1 = new Hilfskraft();
		Transportarbeiter t1 = new Transportarbeiter();
		
		//Software erzeugen
		KaempferSoftwareSS5 kss5 = new KaempferSoftwareSS5();
		GesellschafterSoftwareSS1 gss1 = new GesellschafterSoftwareSS1(); 
		LeibwaechterSoftwareSS4 lss4 = new LeibwaechterSoftwareSS4();
		HilfskraftSoftwareSS1 hss1 = new HilfskraftSoftwareSS1();
		BauarbeiterSoftwareSS3 bss3 = new BauarbeiterSoftwareSS3();
		ServicetechnikerSoftwareSS3 sss3 = new ServicetechnikerSoftwareSS3();
		TransportarbeiterSoftwareSS4 tss4 = new TransportarbeiterSoftwareSS4();
		ObjektbewacherSoftwareSS5 oss5 = new ObjektbewacherSoftwareSS5();
		KaempferSoftwareSS4 kss4 = new KaempferSoftwareSS4();
		TransportarbeiterSoftwareSS3 tss3 = new TransportarbeiterSoftwareSS3();
		
		ok(protokoll.insert(k1, gep, kit4, kss5 ));
		
		/**
		 * In diesem Fall laesst sich der Code gar nicht kompilieren
		 * wird schon zur Compilezeit ueberprueft
		 * diese Kombination wird ueber Wildcards schon verhindert!
		 */
		//ok(!protokoll.insert(new Kaempfer(), gep, kit1, new BedienerSoftwareSS2())));
		
		//Geht nicht, da ein Gesellschafter max. 1kW Leistung haben darf
		ok(!protokoll.insert(g1, behr, kit1, gss1 ));
		
		ok(protokoll.insert(l1, hochf, kit3, lss4 ));
		
		ok(protokoll.insert(h1, behr, kit2, hss1 ));
		
		//Geht nicht, eine gepanzerte Skin duerfen nur Beschuetzer haben
		ok(!protokoll.insert(b1, gep, kit1, bss3));
		
		//Geht nicht, da ein Andriod mit SoftwareStufe 3 nicht mehr als 5kW haben darf
		ok(!protokoll.insert(s1, behr, kit3, sss3));
		
		//Hier geht Kit 3, da die Software mit Stufe 4 zertifiziert ist
		ok(protokoll.insert(t1, hochf, kit3, tss4 ));
		
		//Geht nicht, da nur Kaempfer Software der Stufe 5 haben duerfen
		ok(!protokoll.insert(o1, gep, kit3, oss5));
		
		Iterator<AusgelieferteAndroiden.AusgelieferterAndroid<?>> it = protokoll.iterator();
		
		int size = 0;
		
		while(it.hasNext()) {
			it.next();
			size++;
		}
		ok(size == 4);		
		
		//Ausgabe von ausgelieferten Androiden
		
		System.out.println("Ausgabe aller ausgelieferten Androiden:");
		
		it = protokoll.iterator();
		
		while(it.hasNext()) {
			
			AusgelieferteAndroiden.AusgelieferterAndroid<?> a = it.next();
			
			System.out.println(a.getAndroid().getSerial() +": ");
			System.out.println(a);
		}
		
		//Kit vom ersten Androiden aendern
		ok(protokoll.insert(k1, gep, kit1, kss5));
		
		it = protokoll.iterator();
		size = 0;
		
		while(it.hasNext()) {
			it.next();
			size++;
		}
		//pruefen ob immer noch 4 Androiden in Liste
		ok(size == 4);
		
		//Aenderung geht nicht, da die Sicherheitstufe nicht mehr verandert werden darf
		ok(!protokoll.insert(k1, hochf, kit1, kss4));
		ok(!protokoll.insert(t1, hochf, kit3, tss3));
		
		//Ausgabe nach Aenderungen
		
		System.out.println("Kaempfer geaendert:");
		System.out.println(protokoll.find(k1.getSerial()));		
		
		//Find Mehtode ueberpruefen
		
		it = protokoll.iterator();
		AusgelieferteAndroiden.AusgelieferterAndroid<?> k2 = it.next();
		
		String test = k2.toString();
		ok(test.equals(protokoll.find(k1.getSerial())));
		
		AusgelieferteAndroiden.AusgelieferterAndroid<?> l2 = it.next();
		it.next();
		
		AusgelieferteAndroiden.AusgelieferterAndroid<?> t2 = it.next();
		
		ok(!it.hasNext());
		
		test = l2.toString();
		//Wuerde hier uber die ausgebenen Strings verglichen werden, waeren die Objekte gleich
		//weil sie die Selben Kits und Skins besitzen
		//sind aber tatsaechlich verschieden
		ok(test.equals(protokoll.find(t1.getSerial())));
		
		//Wie hier getestet wird
		ok(!l2.equals(t2));
		
	}
	
	public static void testSkins() {
		BehruerungssenstiverSkin behr = new BehruerungssenstiverSkin();
		HochfesterSkin hochf = new HochfesterSkin();
		GepanzerterSkin gep = new GepanzerterSkin();
		
		//Bediener benoetigen unbedingt eine beruehrungssensitive Skin
		ok(behr.validate(new Gesellschafter()));
		ok(!hochf.validate(new Hilfskraft()));
		ok(!gep.validate(new Gesellschafter()));
		
		//  nur Beschuetzer duerfen eine gepanzerte Skin haben.
		ok(gep.validate(new Kaempfer()));
		ok(gep.validate(new Leibwaechter()));
		
	}
	
	/**
	 * Prueft zwei Objekte auf Gleicheit.
	 * @param o1
	 * @param o2
	 */
	private static <T> void eq(T o1, T o2) {
		tests++;

		if(!o1.equals(o2)) {
			throw new RuntimeException(String.format("\"%s\" != \"%s\"", o1, o2) + String.format(" %s/%s", success, tests) + " tests ok!" );
		} else {
			success++;
		}
	}
	
	/**
	 * Prueft eine Bedingung.
	 * @param o1
	 * @param o2
	 */
	private static <T> void ok(boolean cond) {
		eq(true, cond);
	}

}
