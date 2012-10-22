package ue2;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Event {
	private int score;
	private Map<Mitglied, String> votes;

	private Date beginn;
	private Date ende;
	private String ort;
	
	public Event(String ort, Date beginn, Date end) {
		this.score = 0;
		this.votes = new HashMap<Mitglied, String>();

		this.ort = ort;
		this.beginn = beginn;
		this.ende = end;
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
			votes.put(m, comment);
			score += positive ? 1 : -1;
		}
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
		this.beginn = beginn;
	}

	public Date getEnde() {
		return ende;
	}

	public void setEnde(Date ende) {
		this.ende = ende;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	/**
	 * Liefert die Gesamtkosten bzw. den Gewinn des Events.
	 * @return Gesamtkosten/Gewinn
	 */
	public abstract double abrechnung();
}
