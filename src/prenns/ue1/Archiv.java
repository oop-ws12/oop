package prenns.ue1;

import java.util.Collection;
import java.util.Date;

public interface Archiv<E> extends Collection<E> {
	
	Collection<E> getOldEntries(Date zeitpunkt);
	
}
