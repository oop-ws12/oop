package ue2;

import java.util.ArrayList;

public class ObserverList<T extends EventArgs> extends ArrayList<Observer<T>> {
	private static final long serialVersionUID = -2303518200694813110L;

	public void before(T event) {
		for (Observer<T> observer : this) {
			observer.before(event);
		}
	}

	public void fire(T event) {
		for (Observer<T> observer : this) {
			observer.fired(event);
		}
	}
}
