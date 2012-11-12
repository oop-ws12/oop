//Box <-> ClearBox ist Untertyp von Box, da alle Zusicherungen uebereinstimmen
//und ueberall ClearBox eingesetzt werden kann, wo Box erwartet wird

//Box <-> DarkBox ist kein Untertyp von Box, da es moeglich ist die Zeichen im Nachhinein zu aendern
//bei einer Box ist es nicht mehr moeglich die Zeichen zu aendern

//Box <-> FreeBox, keine Untertypbeziehung, Methoden stimmen nicht ueberein
//FreeBox hat keinen innerChar und keinen borderChar
//ausserdem ist die Nachbedingug von toString() eine andere, statt die Box zu vergroessern, laesst sie den
//inhalt unveraendert und haengt den Inhalt ggf einfach noch einaml daneben oder darueber dazu

//Box <-> Repeated<P> und Scaled<P> fuer unbekannte P, keine Untertypbeziehung
//da in P irgendein Typ sein kann und im Allgemeinen keine Untertypbeziehung gilt

//Box <-> Repeated<Box>
//keine Untertypbeziehung, da in der Methode toString() die Zusicherung in Box verletzt werden koennte, dass
//als Randzeichen keine Leerzeichen verwendet werden durefen. Die Methode fuellt bei zu wenigen Elementen das Bild
//naemlich mit Leerzeichen aus

//Box <-> Repeated<Char>
//keine Untertypbeziehung, da es moeglich sein kann dass das Char ein Leerzeichen ist
//In Box wird dadurch die Zusicherung verletzt, dass das Zeichen fuer den Rand kein Leerzeichen sein darf

//Box <-> Repeated<ClearBox>
//Keine Untertypbeziehung, da nach der Skaleruing im Rand Leerzeichen vorkommen koennten und das die Zusicherung
//in Box verletzen wuerde

//Box <-> Repeated<DarkBox>
//keine Untertypbeziehung, da die Zusicherung in Box verletzt wird, dass die Zeichen nach der Initialsierung
//konstant sind. Sie koennten in DarkBox veraendert werden

//Box <-> Repeated<FreeBox>
//keine Untertypbeziehung, da Leerzeichen als Rand verwendet werden koennen

//Box <-> Scaled<Box>
//es besteht schon eine Untertypbeziehung, da alle Zusicherungen erfuellt sind, denn die Methode scale in Scaled<Box>
//ruft naemlich die scale Methoden der einzelnen Boxen auf, somit entseht wieder eine Box mit einem Rand und einem Inhalt
//Wo das Randzeichen niemals ein Leerzeichen sein kann
//ausserdem ist in Box nicht definiert dass der Rand NUR aus dem gleichen Zeichen bestehen darf, somit koennen verschiedene
//Zeichen von verschiedenen Boxen der Rand sein, ledliglich ein Leerzeichen darf nicht vorkommen

//Box <-> Scaled<ClearBox>
//Scaled<ClearBox> ist ein Untertyp von Box, die Zusicherungen sind erfuellt, da die scale Methode die scale Methoden
//der einzelnen Boxen aufruft, somit kann nie ein Leerzeichen im Rand stehen

//Box <-> Scaled<P> fuer alle anderen Untertypen P von Pict
//keine Untertypbeziehung, da Zusicherungen von Box verletzt werden, es koennen Zeichen im Nachhinein Zeichen
//veraendert werden oder Leerzeichen koennen im Rand vorkommen

//ClearBox <-> DarkBox, keine Untertypbeziehung da es bei DarkBox moeglich ist, die Zeichen im Nachhinen zu aendern

//ClearBox <-> FreeBox, keine Untertypbeziehung, da die Methode toString() in FreeBox nach einer Skalierung
//auch Leerzeichen als Rand hinzufuegen koennte -> Nachbedinung nicht erfuellt

//ClearBox <-> Repeated<P> und Scaled<P> fuer unbekannte P, keine Untertypbeziehung

//DarkBox <-> FreeBox, keine Untertypbeziehung

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
