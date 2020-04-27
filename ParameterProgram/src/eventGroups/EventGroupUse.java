package eventGroups;

import java.io.PrintWriter;

import events.Event;

public class EventGroupUse extends EventGroup{

	
	public EventGroupUse(Event[] events) {
		super(events);
	}
	
	public void createUseCase(PrintWriter writer){
		writer.println("public void use(AbstractPlayer p, AbstractMonster m){");
		this.addEvents(writer);
		writer.println("}");
	}
	
}