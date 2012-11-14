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
		
		eq(4, count(s.iterator()));
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
		
		eq(3, count(s.iterator()));
		eq(true, s.remove(str[0]));
		eq(2, count(s.iterator()));
		s.insert(str[0]);
		
		Iterator<String> it = s.iterator();
		eq(str[1], it.next());
		eq(str[2], it.next());
		eq(str[0], it.next());
		eq(false, it.hasNext());

		eq(true, s.remove(str[2]));
		eq(2, count(s.iterator()));
		
		it = s.iterator();
		eq(str[1], it.next());
		eq(str[0], it.next());
		eq(false, it.hasNext());
		
		eq(true, s.remove(str[0]));
		eq(1, count(s.iterator()));
		
		it = s.iterator();
		eq(str[1], it.next());
		eq(false, it.hasNext());

		s.insert(str[0]);
		s.insert(str[2]);
		
		it = s.iterator();
		eq(3, count(s.iterator()));
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

	/*private static <E> void checkElements(Set<E> set, Collection<E> elements) {
		Iterator<E> d = set.iterator();
		for(E element : elements) {
			eq(element, d.next());
		}
		eq(false, d.hasNext());
	}*/
	
	private static void testTimes() {
		// TODO
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