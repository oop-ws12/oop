public class Test {
	public static void main(String[] args) {
		testBox();
		testClearBox();
		testDarkBox();
		testFreeBox();
		testRepeated();
		testScaled();
		
		System.out.println();
		System.out.println("All tests ok.");
	}
	
	private static void testScaled() {
		Pict[][] ps = new Pict[][] {
				new Pict[] { new DarkBox(3.0d, 3.0d, '1'), new DarkBox(5.0d, 5.0d, '2') },
				new Pict[] { new DarkBox(4.0d, 5.0d, '3'), new DarkBox(4.0d, 3.0d, '4') },
		};
		Scaled<Pict> p1 = new Scaled<Pict>(ps);
		eq("111 22222\n111 22222\n111 22222\n    22222\n    22222\n33334444 \n33334444 \n33334444 \n3333     \n3333     \n", p1.toString());

		/*
		 * Sollte so aussehen:
		 * 

111 22222
111 22222
111 22222
    22222
    22222
33334444 
33334444 
33334444 
3333     
3333     

		 */
	
		p1.scale(2);
		eq("111111  2222222222\n111111  2222222222\n111111  2222222222\n111111  2222222222\n111111  2222222222\n111111  2222222222\n        2222222222\n        2222222222\n        2222222222\n        2222222222\n3333333344444444  \n3333333344444444  \n3333333344444444  \n3333333344444444  \n3333333344444444  \n3333333344444444  \n33333333          \n33333333          \n33333333          \n33333333          \n", p1.toString());
	
		/*
		 * Sollte so aussehen:

111111  2222222222
111111  2222222222
111111  2222222222
111111  2222222222
111111  2222222222
111111  2222222222
        2222222222
        2222222222
        2222222222
        2222222222
3333333344444444  
3333333344444444  
3333333344444444  
3333333344444444  
3333333344444444  
3333333344444444  
33333333          
33333333          
33333333          
33333333          

		 */
	}

	private static void testRepeated() {
		Character[][] data = new Character[][] { toCharacterArray("Test"), toCharacterArray("Hllo") };
		Repeated<Character> p1 = new Repeated<Character>(data);
		
		eq("Test\nHllo\n", p1.toString());
		
		Pict[][] ps = new Pict[][] {
				new Pict[] { new DarkBox(3.0d, 3.0d, '1'), new DarkBox(5.0d, 5.0d, '2') },
				new Pict[] { new DarkBox(4.0d, 5.0d, '3'), new DarkBox(4.0d, 3.0d, '4') },
		};
		Repeated<Pict> p2 = new Repeated<Pict>(ps);
		eq("111 22222\n111 22222\n111 22222\n    22222\n    22222\n33334444 \n33334444 \n33334444 \n3333     \n3333     \n", p2.toString());
	
		/*
		 * Sollte so aussehen:
		 
111 22222
111 22222
111 22222
    22222
    22222
33334444 
33334444 
33334444 
3333     
3333     
		 */
		
		p2.scale(2);
		eq("111 22222111 22222\n111 22222111 22222\n111 22222111 22222\n    22222    22222\n    22222    22222\n33334444 33334444 \n33334444 33334444 \n33334444 33334444 \n3333     3333     \n3333     3333     \n111 22222111 22222\n111 22222111 22222\n111 22222111 22222\n    22222    22222\n    22222    22222\n33334444 33334444 \n33334444 33334444 \n33334444 33334444 \n3333     3333     \n3333     3333     \n", p2.toString());

		/*
		 * Sollte so aussehen:

111 22222111 22222
111 22222111 22222
111 22222111 22222
    22222    22222
    22222    22222
33334444 33334444 
33334444 33334444 
33334444 33334444 
3333     3333     
3333     3333     
111 22222111 22222
111 22222111 22222
111 22222111 22222
    22222    22222
    22222    22222
33334444 33334444 
33334444 33334444 
33334444 33334444 
3333     3333     
3333     3333     

		 */
	}
	
	private static Character[] toCharacterArray(String s) {
	   Character[] array = new Character[s.length()];
	   for (int i = 0; i < s.length(); i++) {
	      array[i] = new Character(s.charAt(i));
	   }
	   return array;
	}
	
	private static void testFreeBox() {
		Pict p1 = new FreeBox("1234\n5678");
		eq(p1.toString(), "1234\n5678\n");
		
		p1.scale(1.5d);
		eq(p1.toString(), "123412\n567856\n123412\n");
	}

	private static void testDarkBox() {
		DarkBox p1 = new DarkBox(3.0d, 3.0d, 'c');
		eq(p1.toString(), "ccc\nccc\nccc\n");
		
		p1.setTheChar('*');
		
		AbstractBox p2 = p1;
		eq(p2.toString(), "***\n***\n***\n");
	}

	private static void testClearBox() {
		ClearBox p1 = new ClearBox(3.0d, 3.0d);
		eq(p1.getScale(), 1.0d);
		eq(p1.toString(), "***\n* *\n***\n");
	}

	private static void testBox() {
		Pict p1 = new Box(1, 1, '.', 'o');
		eq(p1.toString(), "o\n");
		
		p1.scale(2);
		eq(p1.toString(), "oo\noo\n");
		
		p1.scale(2);
		eq(p1.toString(), "oooo\no..o\no..o\noooo\n");
		
		Pict p2 = new Box(3.7d, 2.3d, '.', 'o');
		eq(p2.toString(), "oooo\no..o\noooo\n");
	}
	
	private static void eq(Object o1, Object o2) {
		if(o1.equals(o2)) {
			System.out.print(".");
		} else {
			throw new RuntimeException(String.format("\"%s\" != \"%s\"", o1, o2));
		}
	}
}
