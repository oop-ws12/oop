package ue2;

public interface Observable<T extends EventArgs> {
	void addObserver(Observer<T> observer);

	void removeObserver(Observer<T> observer);
}
