package ue2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeletionListTest extends UnitTest {
	private static final DateFormat date = new SimpleDateFormat("d.M.y");

	@Override
	public void start() {
		DeletionList<String> l = new DeletionList<String>();
		Date z1 = null;
		Date z2 = null;

		try {
			z1 = date.parse("01.02.2012");
			z2 = date.parse("01.03.2012");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		l.add("s1", z1);
		l.add("s2", z1);
		l.add("s3", z1);
		l.add("s4", z2);

		ok(l.list().size() == 4);
		ok( l.list(z1).size() == 3);

		ok(l.remove("s4"));
		ok( l.list().size() == 3);
		ok( l.list(z1).size() == 3);

		l.remove("s1");
		ok( l.list().size() == 2);
		ok( l.list(z1).size() == 3);
	}

}
