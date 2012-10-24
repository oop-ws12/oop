
public class GesperrtException extends Exception {

	private static final long serialVersionUID = -3021091368411949293L;

	private Mitglied m;

	public GesperrtException(Mitglied m) {
		this.m = m;
	}

	@Override
	public String getMessage() {

		return m.toString() + " ist gesperrt fuer diesen Auftritt!";
	}
}
