package prenns.MusicSystem;

public class EventStackNode {

	private Event event;
	private EventStackNode next;

	public EventStackNode(Event event, EventStackNode next) {

		this.event = event;
		this.next = next;
	}

	public Event getEvent() {

		return event;
	}

	public EventStackNode getNext() {

		return next;
	}

	public int size() {

		if (next == null)
			return 1;

		else
			return next.size();
	}
}
