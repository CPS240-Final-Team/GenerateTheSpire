package eventGroups;

import java.io.PrintWriter;

import events.Event;

public class EventGroupUpgrade extends EventGroup{

	
	public EventGroupUpgrade(Event[] events) {
		super(events);
	}
	
	public void createUseCase(PrintWriter writer){
		writer.println("public void upgrade() {");
		writer.println("if (!this.upgraded) {");
		this.addEvents(writer);
		writer.println("}");
		writer.println("}");
	}
}