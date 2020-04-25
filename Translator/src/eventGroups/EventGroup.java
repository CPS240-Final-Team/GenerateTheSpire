package eventGroups;

import java.io.PrintWriter;

import events.Event;

public abstract class EventGroup{

	public Event[] events;

	public EventGroup(Event[] events) {
		this.events = events;
	}


	public void createUseCase(PrintWriter writer){

	}



	public void addEvents(PrintWriter writer) {
		for (int i=0; i<events.length; i++){
			this.events[i].generateEvent(writer);
		}
	}

}
