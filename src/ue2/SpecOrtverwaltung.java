
import java.util.ArrayList;
import java.util.Collection;

public class SpecOrtverwaltung extends SpecificationTest {

	@Override
	protected String getSpecification() {
		return "Nachdem Auftritte und vor allem Proben haeufig am selben Ort stattfinden,\n" 
			   + "sollte es eine eigene Verwaltung dieser Orte geben. Die wichtigste Infrastruktur dieser Orte \n" 
			   + "sollte leicht auffindbar beschrieben sein. Man soll geeignete Orte auch anhand bestimmter Infrastruktur \n" 
			   + "waehlen koennen.";
	}

	@Override
	public void test() throws Exception {
		
		desc("3 Orte werden erstellt");
		Ort wien = new Ort("Wien");
		Ort neustadt = new Ort("Wiener Neustadt");
		Ort graz = new Ort("Graz");
		
		desc(wien.getName() + " wird Infrastruktur hinzugefuegt");
		wien.addInfra(EventType.PROBE, "Mustergasse 10", "Proberaum");
		wien.addInfra(EventType.AUFTRITT, "Am Ring 2", "Halle");
		
		desc(neustadt.getName() + " wird Infrastruktur hinzugefuegt");
		neustadt.addInfra(EventType.PROBE, "Porsche Ring 8", "Probekeller");
		neustadt.addInfra(EventType.AUFTRITT, "Xy Gasse 5", "Arena");
		
		desc(graz.getName() + " wird Infrastruktur hinzugefuegt");
		graz.addInfra(EventType.AUFTRITT, "Musterstrasse 5", "Stadion");
		
		
		desc("Orte werden der Ortweraltung hinzugefuegt");
		Ortverwaltung verw = new Ortverwaltung();
		
		ok(verw.add(wien), wien.getName() + " zur Ortverwaltung hinzugefuegt");
		ok(verw.add(graz), graz.getName() + " zur Ortverwaltung hinzugefuegt");
		ok(verw.add(neustadt), neustadt.getName() + "zur Ortverwaltung hinzugefuegt");
		
		Collection<Ort> probeort = new ArrayList<Ort>();
		
		desc("Es werden Orte gesucht, welche fuer Proben geeignet sind");
		
		probeort = verw.getIdealOrte(EventType.PROBE);
		
		ok(probeort.size() == 2, "Anzahl der geeigneten Orte muss 2 sein");
		
		desc("Es werden Orte gesucht, welche fuer Auftritte geeignet sind");
		
		probeort = verw.getIdealOrte(EventType.AUFTRITT);
		
		ok(probeort.size() == 3, "Anzahl der geeigneten Orte muss 3 sein");
	}

}
