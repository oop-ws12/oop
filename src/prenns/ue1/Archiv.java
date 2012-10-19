package prenns.ue1;

import java.util.Collection;
import java.util.Date;

public interface Archiv<E> extends Collection<E> {
	
	Collection<E> getOldEntries(Date zeitpunkt);
	
	public boolean add(E elem, Date time);
	
	public boolean remove(E elem, Date time);
}
