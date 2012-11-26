import java.util.HashMap;
import java.util.Map;

public class Conditional {
	public static abstract class Action<R> {
		public static class TrueAction extends Action<Boolean> {
			@Override
			public Boolean map() {
				return true;
			}
		}
		
		public static class FalseAction extends Action<Boolean> {
			@Override
			public Boolean map() {
				return false;
			}
		}
		
		public abstract R map();
	}
	
	boolean value;
	
	public Conditional(boolean value) {
		this.value = value;
	}
	
	public <R> R fold(Action<R> fTrue, Action<R> fFalse) {
		Map<Boolean, Action<R>> table = new HashMap<Boolean, Action<R>>();
		table.put(true, fTrue);
		table.put(false, fFalse);
		
		return table.get(value).map();
	}
	
	public boolean foldTrue(Action<Boolean> fTrue) {
		return fold(fTrue, new Action.FalseAction());
	}
	
	public boolean foldFalse(Action<Boolean> fFalse) {
		return fold(new Action.TrueAction(), fFalse);
	}
}
