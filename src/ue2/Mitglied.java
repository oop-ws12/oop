package ue2;

public class Mitglied extends Model<Mitglied> implements
		Observer<ChangedEvent<Event>> {
	private String name;
	private String telefon;
	private String instrument;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public Mitglied(String name, String telefon, String instrument) {
		this.name = name;
		this.telefon = telefon;
		this.instrument = instrument;
	}

	@Override
	public String toString() {
		return "Mitglied [name=" + name + ", instrument=" + instrument + "]";
	}

	@Override
	public Mitglied copy() {
		return new Mitglied(name, telefon, instrument);
	}

	@Override
	public void before(ChangedEvent<Event> event) {
	}

	@Override
	public void fired(ChangedEvent<Event> event) {
		// Ein event wurde geaendert.
	}
}
