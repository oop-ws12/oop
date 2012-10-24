
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Testet eine Spezifikation.
 */
public abstract class SpecificationTest extends AbstractTest {
	protected static final DateFormat date = new SimpleDateFormat("d.M.y");

	protected abstract String getSpecification();

	protected void ok(boolean cond, String d) {
		System.out.print("  Test: " + d + ": ");
		if (cond) {
			System.out.println("OK");
		} else {
			System.out.println("Fehler");
			throw new RuntimeException();
		}
	}

	@Override
	public void start() {
		System.out.println("Spezifikation: " + getSpecification());
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void test() throws Exception;

	protected MusikGruppe getDefaultMusikGruppe() {
		MusikGruppe g1 = new MusikGruppe("Oberkrainer", "Volksmusik");
		Ort wopfing = new Ort("Wopfing");

		BigDecimal d1 = new BigDecimal(20);

		try {

			g1.addMember(new Mitglied("Lukas", "00", "Floete"),
					date.parse("01.02.1992"));
			g1.addMember(new Mitglied("Alex", "01", "Trompete"),
					date.parse("01.02.1992"));
			g1.addMember(new Mitglied("Frieda", "02", "Orgel"),
					date.parse("04.02.1992"));
			g1.addMember(new Mitglied("Bella", "03", "Bass"),
					date.parse("09.02.1992"));

			g1.addEvent(new Probe(wopfing, date.parse("10.02.2012"), date
					.parse("10.02.2012"), d1, g1.getMembers()));
			g1.addEvent(new Probe(new Ort("Wr. Neustadt"), date
					.parse("20.02.2012"), date.parse("20.02.2012"), d1, g1
					.getMembers()));
			g1.addEvent(new Auftritt(wopfing, date.parse("21.02.2012"), date
					.parse("21.02.2012"), new BigDecimal(555), g1.getMembers(),
					date.parse("14.02.2012"), date.parse("20.02.2012"), 2));

		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch (GesperrtException e) {
			e.printStackTrace();
		}

		return g1;
	}
}
