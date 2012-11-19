import java.util.Iterator;

public class Test {
	
	public static void main(String[] args) {
		testSets();
		testTimes();
		
		System.out.println();
		System.out.println("All tests ok.");
	}

	private static void testSets() {
		testSet();
		testOrderedSet();
		testOrderedMap();
	}
	
	private static void testOrderedMap() {
		OrderedMap<Description, String> m = new OrderedMap<Description, String>();
		Description[] d = new Description[] {
			new Description("Dhgsdhj"),
			new Description("Dhjskdaasdjklasd"),
			new Description("De"),
			new Description("asdasadsasd")
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

	private static void testOrderedSet() {
		Set<Description> s = new OrderedSet<Description>();
		Description[] d = new Description[] {
			new Description("Dhgsdhj"),
			new Description("Dhjskdaasdjklasd"),
			new Description("De"),
			new Description("asdasadsasd")
		};
		
		for(Description e : d)
			s.insert(e);
		
		eq(4, s.count());
		Iterator<Description> it = s.iterator();
		eq(d[2], it.next());
		eq(d[0], it.next());
		eq(d[3], it.next());
		eq(d[1], it.next());
		eq(false, it.hasNext());
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


	private static void testTimes() {
		
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