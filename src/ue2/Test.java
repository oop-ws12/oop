package ue2;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<UnitTest> unit = new ArrayList<UnitTest>();
		unit.add(new DeletionListTest());
		unit.add(new MusikGruppeTest());
		
		for (UnitTest u : unit) {
			u.start();
		}

		System.out.println("\n\nSpezifikationen\n\n");

		List<SpecificationTest> spec = new ArrayList<SpecificationTest>();
		spec.add(new SpecEventPlanung());
		spec.add(new SpecChangeEvent());
		spec.add(new SpecEventInform());

		for (SpecificationTest u : spec) {
			u.start();
		}

		System.out.println("OK");
	}
}
