package ue2;

public interface Observer<T extends EventArgs> {
	/**
	 * Invoked before the Event is fired.
	 * 
	 * @param event
	 */
	void before(T event);

	/**
	 * Invoked when the Event is fired.
	 * 
	 * @param event
	 */
	void fired(T event);
}
