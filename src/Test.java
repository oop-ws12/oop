import java.util.Iterator;

public class Test {
	private static OrderedMap<MeanElapsedTime, CompositeTime> testMap;
	
	public static void main(String[] args) {
		// Unit Tests
		testShorter();
		testSet();
		testOrderedMap();
		
		// Tests laut Angabe
		testNr1();
		testNr2();
		testNr3();
		testNr4();
		
		
		System.out.println();
		System.out.println("All tests ok.");
	}

	private static void testNr4() {
		System.out.println("--- Test 4 ---");

		OrderedSet<ElapsedTime> set = new OrderedSet<ElapsedTime>();
		MapIterator<MeanElapsedTime, CompositeTime> it = testMap.iterator();
		while(it.hasNext()) {
			set.insert(it.next());
			Iterator<CompositeTime> compIt = it.iterator();
			while(compIt.hasNext()) {
				set.insert(compIt.next());
			}
		}
		
		for(ElapsedTime e : set) {
			System.out.println(e.count());
		}
	}

	private static void testNr3() {
		System.out.println("--- Test 3 ---");
		
		OrderedSet<MeanElapsedTime> set = testMap;
		Set<Double> times = new Set<Double>();
		times.insert(133d);
		times.insert(123d);
		times.insert(153d);
		
		set.insert(new MeanElapsedTime(times));
		
		for(MeanElapsedTime time : set) {
			System.out.println(time.highestValue());
		}
	}
	
	private static void testOrderedMap() {		
		OrderedMap<Description, String> m = new OrderedMap<Description, String>();
		Description[] d = new Description[] {
			new Description("Dhgsdhj\na"),
			new Description("Dhjsk\ndaa\nsd\njk\nlasd"),
			new Description("Deww"),
			new Description("asdasa\ndsa\nd")
		};
		
		for(Description e : d)
			m.insert(e);
		
		eq(4, m.count());
		MapIterator<Description, String> it = m.iterator();
		eq(d[2], it.next());
		eq(d[0], it.next());
		eq(d[3], it.next());
		eq(d[1], it.next());
		eq(false, it.hasNext());
		
		it = m.iterator();
		eq(d[2], it.next());
		InsertIterator<String> firstStrs = it.iterator();
		eq(0, count(firstStrs));
		firstStrs = it.iterator();
		firstStrs.add("Hoho");
		firstStrs.add("Foo");
		
		firstStrs = it.iterator();
		eq(2, count(firstStrs));
	}

	private static void testNr1() {
		System.out.println("--- Test 1 ---");
		
		Set<Description> s = new OrderedSet<Description>();
		Description[] d = new Description[] {
			new Description("Dhgsdhj\na"),
			new Description("Dhjsk\ndaa\nsd\njk\nlasd"),
			new Description("Deww"),
			new Description("asdasa\ndsa\nd")
		};
		
		for(Description e : d)
			s.insert(e);
		
		for(Description e : s) {
			System.out.println(e.lineCount());
		}
		System.out.println("---");
		
		eq(4, s.count());
		Iterator<Description> it = s.iterator();
		eq(d[2], it.next());
		eq(d[0], it.next());
		eq(d[3], it.next());
		eq(d[1], it.next());
		eq(false, it.hasNext());
		
		// Aenderungen
		s.remove(d[1]);
		Description n = new Description("jsdhk\nja");
		s.insert(n);
		
		eq(4, s.count());
		it = s.iterator();
		eq(d[2], it.next());
		eq(n, it.next());
		eq(d[0], it.next());
		eq(d[3], it.next());
		eq(false, it.hasNext());
		
		for(Description e : s) {
			System.out.println(e.lineCount());
		}
	}

	private static void testSet() {
		Set<String> s = new Set<String>();
		String[] str = new String[] { "Hello", "Haha", "fff" };
		
		s.insert(str[0]);
		s.insert(str[1]);
		s.insert(str[2]);
		
		eq(3, s.count());
		eq(true, s.remove(str[0]));
		eq(2, s.count());
		s.insert(str[0]);
		
		Iterator<String> it = s.iterator();
		eq(str[1], it.next());
		eq(str[2], it.next());
		eq(str[0], it.next());
		eq(false, it.hasNext());

		eq(true, s.remove(str[2]));
		eq(2, s.count());
		
		it = s.iterator();
		eq(str[1], it.next());
		eq(str[0], it.next());
		eq(false, it.hasNext());
		
		eq(true, s.remove(str[0]));
		eq(1, s.count());
		
		it = s.iterator();
		eq(str[1], it.next());
		eq(false, it.hasNext());

		s.insert(str[0]);
		s.insert(str[2]);
		
		it = s.iterator();
		eq(3, s.count());
		eq(str[1], it.next());
		it.remove();
		eq(str[0], it.next());
		eq(str[2], it.next());
		it.remove();
		
		it = s.iterator();
		eq(1, count(s.iterator()));
	}
	
	private static <E> int count(Iterator<E> item) {
		int count = 0;
		while(item.hasNext()) {
			count++;
			item.next();
		}
		return count;
	}


	private static void testNr2() {
		System.out.println("--- Test 2 ---");
		
		//Map erstellen
		testMap = new OrderedMap<MeanElapsedTime, CompositeTime>();
		
		//Sets erstellen
		Set<Double> set1 = new Set<Double>();
		Set<Double> set2 = new Set<Double>();
		
		//Messreihen erstellen
		Double[] messwerte1 = new Double[] { 13.0, 14.2, 1.4, 0.5 };
		Double[] messwerte2 = new Double[] { 4.0, 100.4, 20.9, 3.5, 80.2 };
		Double[] messwerte3 = new Double[] { 4.6, 10.4, 220.9, 33.5, 8.2 };
		
		//Sets mit den Messreihen initialisieren
		for(double d : messwerte1) {
			set1.insert(d);
		}
		for(double d : messwerte2) {
			set2.insert(d);
		}
		
		//Zeiten erstellen
		MeanElapsedTime[] times = new MeanElapsedTime[]	{
				
				new MeanElapsedTime(set1),
				new MeanElapsedTime(set2)		
		};
		
		//Map mit den Zeiten initialisieren
		for(MeanElapsedTime t : times) {
			testMap.insert(t);
		}
		
		//Objekte erzeugen und mit Messwerten initialisieren
		CompositeTime[] comps = new CompositeTime[] {
				
				new CompositeTime(messwerte3),
				new CompositeTime(messwerte1),	
				new CompositeTime(messwerte2),
		};
		
		//Iterator ueber die Map
		MapIterator<MeanElapsedTime, CompositeTime> it = testMap.iterator();
		//Auf das erste Element der Map gehen
		it.next();
		//Iterator vom ersten Element ueber die Objekte 
		InsertIterator<CompositeTime> insertTimes = it.iterator();
		
		//Objekte, auf welche das erste Element verweist, einfuegen
		insertTimes.add(comps[0]);
		insertTimes.add(comps[2]);
		//Auf das zweite Element in der Map gehen
		it.next();
		//Iterator vom zweiten Element
		insertTimes = it.iterator();
		//Objekte, auf welche das zweite Element verweist, einfuegen
		insertTimes.add(comps[1]);
		
		it = testMap.iterator();
		
		//Erstes Element in der Map
		MeanElapsedTime current = it.next();
		
		//Ausgabe des groessten Messwertes vom ersten Element MeanElapsedTime
		eq(messwerte1[1], current.highestValue());
		System.out.println(current.highestValue());
		
		//Iterator vom ersten Element ueber die CompositeTimes, zeigt auf das ZULETZT eingefuegte Element
		insertTimes = it.iterator();
				
		//Erstes Objekt vom ersten Element in der Map
		CompositeTime current2 = insertTimes.next();
		
		//Ausgabe der kurezesten Zeit des ersten Objekts
		eq(messwerte2[3], current2.getShortestTime());
		System.out.println(current2.getShortestTime());
		
		//Zweites Objekt vom ersten Element
		current2 = insertTimes.next();
		
		eq(messwerte3[0], current2.getShortestTime());
		System.out.println(current2.getShortestTime());
		
		current = it.next();
		insertTimes = it.iterator();
	
		eq(messwerte2[1], current.highestValue());
		System.out.println(current.highestValue());
		
		current2 = insertTimes.next();
	
		eq(messwerte1[3], current2.getShortestTime());
		System.out.println(current2.getShortestTime());
	}
	
	private static void testShorter() {
		
		//Sets erstellen
		Set<Double> set1 = new Set<Double>();
		Set<Double> set2 = new Set<Double>();
				
		//Messreihen erstellen
		Double[] messwerte1 = new Double[] { 13.0, 14.2, 1.4, 0.5 };
		Double[] messwerte2 = new Double[] { 4.0, 100.4, 20.9, 3.5, 80.2 };
		Double[] messwerte3 = new Double[] { 4.6, 10.4, 220.9, 33.5, 8.2 };
				
		//Sets mit den Messreihen initialisieren
		for(double d : messwerte1) {
			set1.insert(d);
		}
		for(double d : messwerte2) {
			set2.insert(d);
		}
		
		MeanElapsedTime t1 = new MeanElapsedTime(set1);
		MeanElapsedTime t2 = new MeanElapsedTime(set2);
		
		CompositeTime t3 = new CompositeTime(messwerte3);
		ElapsedTime t4 = new CompositeTime(messwerte1);
		
		eq(true, t1.shorter(t2));
		eq(false,t3.shorter(t1));
		eq(true, t1.shorter(t4));
	}

	/**
	 * Prueft zwei Objekte auf Gleicheit.
	 * @param o1
	 * @param o2
	 */
	private static <T> void eq(T o1, T o2) {
		if(!o1.equals(o2)) {
			throw new RuntimeException(String.format("\"%s\" != \"%s\"", o1, o2));
		}
	}
}