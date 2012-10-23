package ue2;

import java.util.ArrayList;
import java.util.Collection;

public class OrtTest extends UnitTest {

	@Override
	public void start() {
		
		Ort wien = new Ort("Wien");
		Ort neustadt = new Ort("Wiener Neustadt");
		Ort graz = new Ort("Graz");
		
		wien.addInfra(EventType.PROBE, "Mustergasse 10", "Proberaum");
		wien.addInfra(EventType.AUFTRITT, "Am Ring 2", "Halle");
		neustadt.addInfra(EventType.PROBE, "Porsche Ring 8", "Probekeller");
		graz.addInfra(EventType.AUFTRITT, "Musterstrasse 5", "Stadion");
		
		Ortverwaltung verw = new Ortverwaltung();
		
		ok(verw.add(wien));
		ok(verw.add(graz));
		ok(verw.add(neustadt));
		
		Collection<Ort> probeort = new ArrayList<Ort>();
		
		probeort = verw.getIdealOrte(EventType.AUFTRITT);
		
		ok(probeort.size() == 2);
		
		probeort = verw.getIdealOrte(EventType.PROBE);
		
		ok(probeort.size() == 2);
		
	}
	
	

}
