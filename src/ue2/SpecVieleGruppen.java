
public class SpecVieleGruppen extends SpecificationTest {

	@Override
	protected String getSpecification() {
		return "Wenn es sich bewaehrt, soll das System nicht nur zur Verwaltung einer \n" +  
				"Musikgruppe, sondern zum professionellen Management vieler Gruppen \n" + 
				"eingesetzt werden. Dafuer sind Vorkehrungen zu treffen";
	}

	@Override
	public void test() throws Exception {
		desc("Es koennen problemlos mehrere Instanzen der Klasse MusikGruppe erzeugt \nwerden ohne das es zu Problemen kommt");
	}

}
