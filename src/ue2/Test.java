
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<UnitTest> unit = new ArrayList<UnitTest>();
		unit.add(new DeletionListTest());
		unit.add(new MusikGruppeTest());
		unit.add(new OrtTest());
		
		for (UnitTest u : unit) {
			u.start();
		}

		System.out.println("\n\n----- Spezifikationen -----\n\n");

		List<SpecificationTest> spec = new ArrayList<SpecificationTest>();
		spec.add(new SpecEventPlanung());
		spec.add(new SpecChangeEvent());
		spec.add(new SpecVieleGruppen());
		spec.add(new SpecEventInform());
		spec.add(new SpecLiedVarianten());
		
		spec.add(new SpecOrtverwaltung());
		spec.add(new SpecFinanzverwaltung());
		spec.add(new SpecErsatzMitglieder());

		for (SpecificationTest u : spec) {
			u.start();
			System.out.println("\n\n---------------\n");
		}

		System.out.println("OK");
	}
}