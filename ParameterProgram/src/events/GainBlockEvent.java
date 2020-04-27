package events;

import java.io.PrintWriter;


public class GainBlockEvent extends Event{

	public GainBlockEvent() {
		super("1");
	}
	public GainBlockEvent(String repetitions) {
		super(repetitions);
	}
	
	public void generateEvent(PrintWriter writer) {
		if (this.doesRepeat) {
			this.generateRepetition(writer);
		}
		
		writer.println("addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));");
		
		if (this.doesRepeat) {
			System.out.println("}");
		}
	}
	
}

///* 38 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
