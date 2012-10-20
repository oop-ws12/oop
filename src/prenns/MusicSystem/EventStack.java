package prenns.MusicSystem;

public class EventStack {

		private EventStackNode top;
		
		public boolean empty() {
			return this.size() == 0;	
		}
		
		public Event pop() {
		
			Event result = top.getEvent();
			top = top.getNext();
			return result;
				
		}
		
		public Event peek() {	
		
			if(this.empty())
				return null;
			else return top.getEvent();
		}
		
		public void push(Event event) {
		
		top = new EventStackNode(event, top);	
		}
		
		public int size() {
			
			if(top == null)
				return 0;
			
			else return top.size();
		}
			
	}

