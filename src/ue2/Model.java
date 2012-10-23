package ue2;

/**
 * Stellt die Basisklasse aller Objekte dar die folgende Eigenschaften haben:
 * 
 * *) beobachtbar auf Aenderungen 
 * *) kopierbar (cloneable)
 * 
 * @param <T>
 */
public abstract class Model<T> implements Observable<ChangedEvent<T>>,
		Copyable<T> {
	protected ObserverList<ChangedEvent<T>> observers = new ObserverList<ChangedEvent<T>>();

	@Override
	public void addObserver(Observer<ChangedEvent<T>> observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer<ChangedEvent<T>> observer) {
		observers.remove(observer);
	}
}
