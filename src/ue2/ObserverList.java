package ue2;

import java.util.ArrayList;

/**
 * Stellt eine Liste von Beobachtern dar.
 *
 * @param <T>
 */
public class ObserverList<T extends EventArgs> extends ArrayList<Observer<T>> implements Observer<T> {
	private static final long serialVersionUID = -2303518200694813110L;

	@Override
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

	@Override
	public void fired(T event) {
		fire(event);
	}
}
