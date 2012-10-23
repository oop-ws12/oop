package ue2;


class SpecEventInform extends SpecificationTest {
	class TestMitglied extends Mitglied {
		public int count = 0;
		
		public TestMitglied(String name, String telefon, String instrument) {
			super(name, telefon, instrument);
		}
		@Override
		public void fired(ChangedEvent<Event> event) {
			super.fired(event);
			desc(toString() + " wurde ueber die Aenderung des Events informiert.");
			count++;
		}
	}
	
	@Override
	protected String getSpecification() {
		return "Es soll moeglich sein, Proben und Auftritte anzusetzen,\n zu verschieben und abzusagen. Darueber sollen die Mitglieder\n der Musikgruppe automatisch informiert werden.";
	}

	@Override
	public void test() throws Exception {
		MusikGruppe g = getDefaultMusikGruppe();
		
		TestMitglied u1 = new TestMitglied("Lukas", "0022", "Harfe");
		TestMitglied u2 = new TestMitglied("Judith", "0012", "Orgel");

		desc("Erzeuge Mitglied" + u1.toString());
		desc("Erzeuge Mitglied" + u2.toString());
		
		g.addMember(u1);
		g.addMember(u2);
		
		Event e = g.getEvents(date.parse("01.01.2004"), date.parse("01.01.2013")).iterator().next();
		desc("Event " + e.toString() + " von " + date.format(e.getBeginn()) + " - " + date.format(e.getEnde()));
		
		desc("Verschiebe Event: " + e.toString() + " von " + date.format(e.getBeginn()) + " - " + date.format(e.getEnde()));
		e.setZeitraum(date.parse("01.01.2013"), date.parse("02.01.2013"));
		
		ok(u1.count == 1, "Mitglied 1 sollte ueber eine Aenderung informiert werden sein");
		ok(u2.count == 1, "Mitglied 2 sollte ueber eine Aenderung informiert werden sein");
	}

}
