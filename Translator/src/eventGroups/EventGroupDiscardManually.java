package eventGroups;

import java.io.PrintWriter;

import events.Event;

public class EventGroupDiscardManually extends EventGroup{

	
	public EventGroupDiscardManually(Event[] events) {
		super(events);
	}
	
	public void createUseCase(PrintWriter writer){
		writer.println("public void triggerOnManualDiscard() {");
		this.addEvents(writer);
		writer.println("}");
	}
}