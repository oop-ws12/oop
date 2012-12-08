
public class Test {

	public static void main(String[] args) {
<<<<<<< HEAD
=======
		long zstVorher;
		long zstNachher;
		
		zstVorher = System.currentTimeMillis();
		
		testMove();
		testlauf1();
		testlauf2();
		testlauf3();
		
		zstNachher = System.currentTimeMillis();
		
		System.out.println(String.format("Tests nach %s Millisekunden terminiert", zstNachher - zstVorher));
		System.out.println(String.format("%s/%s Tests erfolgreich!", success, tests));
	}
>>>>>>> origin/master
	
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
		
<<<<<<< HEAD
		t1.changeEinsatzzweck(d3);
		t2.changeEinsatzzweck(d2);
=======
		game1.start();
		game1.waitForFinish();
		success++;
		
	}
	
	private static void testlauf2() {
>>>>>>> origin/master
	
		t3.setBetriebsstunden(500);
		
		Bauernhof b1 = new Bauernhof("EdisHof");
			
<<<<<<< HEAD
		b1.addTraktor(t1);
		b1.addTraktor(t2);
		b1.addTraktor(t3);
		b1.addTraktor(t5);

		b1.erhoeheSpritVerbrauch(t1.getSerial(),200);
		b1.erhoeheSpritVerbrauch(t5.getSerial(),240);
=======
		game2.start();
		game2.waitForFinish();

		success++;
	}
	
	private static void testlauf3() {
		
		System.out.println("Starte Testlauf 3: ");
		tests++;
		Game game3 = new Game(30, 40);
		
		for(int i = 0; i < 30; i++) {
			Car c1 = new FastCar(game3, new MoveStrategy.Random(FastCar.getValidMoves()));
			c1.setAngle(90);
		}
		
		for(int i = 0; i < 10; i++) {
			Car c = new MoveCar(game3, new MoveStrategy.Always(Move.FWD));
			c.setAngle(270);
		}
		game3.start();
		game3.waitForFinish();

		success++;
	}
>>>>>>> origin/master
	
		Traktor T = new BiogasTraktor();
		b1.addTraktor(T);
		
		System.out.println(b1);
		System.out.println("Anzahl der durchschn. Betriebsstunden von Duengstreuer: " + b1.getAverageBetrieb(null, d3));
		System.out.println("Anzahl des durchschn. DieselVerbauch von Duengstreuer: " + b1.getAverageSpritVerbrauch(t1,d3));
		System.out.println("Anzahl des durchschn. DieselVerbauch von Duengstreuer: " + b1.getMinAnzahlSaeschare(null));
		System.out.println("Anzahl des durchschn. DieselVerbauch von Duengstreuer: " + b1.getMaxAnzahlSaeschare(null));
	}

}
