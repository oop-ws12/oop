package ue2;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Stellt ein Event der MusikGruppe dar.
 */
public abstract class Event extends Model<Event> {
	protected ChangedEvent<Event> changed = new ChangedEvent<Event>(this);

	private int score;
	private Map<Mitglied, String> votes;

	private Date beginn;
	private Date ende;
	private Ort ort;
	
	public Event(Ort ort, Date beginn, Date end) {
		this.score = 0;
		this.votes = new HashMap<Mitglied, String>();

		this.ort = ort;
		this.beginn = beginn;
		this.ende = end;
	}

	public Event(Event o) {
		this.ort = o.ort;
		this.beginn = new Date(o.beginn.getTime());
		this.ende = new Date(o.ende.getTime());
		this.score = o.score;
		this.votes = new HashMap<Mitglied, String>(o.votes);
	}
	
	/**
	 * Stimmt fuer/gegen das Event.
	 * 
	 * @param m
	 *            das Mitglied
	 * @param positive
	 *            dafuer/dagegen
	 * @param comment
	 *            Kommentar
	 */
	public void addVote(Mitglied m, boolean positive, String comment) {
		if (!votes.containsKey(m)) {
			this.observers.before(changed);
			votes.put(m, comment);
			score += positive ? 1 : -1;
			this.observers.fire(changed);
		}
	}
	
	public int getScore() {
		return score;
	}

	public Map<Mitglied, String> getVotes() {
		return Collections.unmodifiableMap(votes);
	}

	/**
	 * Liefert true wenn das Event abgesagt ist.
	 * 
	 * @return
	 */
	public boolean isCanceled() {
		return score <= -2;
	}

	public Date getBeginn() {
		return beginn;
	}

	public void setBeginn(Date beginn) {
		this.observers.before(changed);
		this.beginn = beginn;
		this.observers.fire(changed);
	}

	public Date getEnde() {
		return ende;
	}

	public void setEnde(Date ende) {
		this.observers.before(changed);
		this.ende = ende;
		this.observers.fire(changed);
	}

	public Ort getOrt() {
		return ort;
	}

	public void setOrt(Ort ort) {
		this.observers.before(changed);
		this.ort = ort;
		this.observers.fire(changed);
	}
	
	public void setZeitraum(Date begin, Date ende) {
		this.observers.before(changed);
		this.beginn = begin;
		this.ende = ende;
		this.observers.fire(changed);
	}

	/**
	 * Liefert die Gesamtkosten bzw. den Gewinn des Events.
	 * @return Gesamtkosten/Gewinn
	 */
	public abstract double abrechnung();
}
