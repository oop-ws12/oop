package ue2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeletionListTest extends UnitTest {
	private static final DateFormat date = new SimpleDateFormat("d.M.y");

	@Override
	public void start() {
		DeletionList<Mitglied> l = new DeletionList<Mitglied>();
		Date z1 = null;
		Date z2 = null;

		Mitglied m1 = new Mitglied("s1", "f", "g");
		Mitglied m2 = new Mitglied("s2", "f", "g");
		Mitglied m3 = new Mitglied("s3", "f", "g");
		Mitglied m4 = new Mitglied("s4", "f", "g");

		try {
			z1 = date.parse("01.02.2012");
			z2 = date.parse("01.03.2012");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		l.add(m1, z1);
		l.add(m2, z1);
		l.add(m3, z1);
		l.add(m4, z2);

		ok(l.list().size() == 4);
		ok(l.list(z1).size() == 3);

		ok(l.remove(m4));
		ok(l.list().size() == 3);
		ok(l.list(z1).size() == 3);

		l.remove(m1);
		ok(l.list().size() == 2);
		ok(l.list(z1).size() == 3);
	}

}
