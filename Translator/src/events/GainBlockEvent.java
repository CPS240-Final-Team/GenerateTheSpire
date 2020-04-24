package events;

import java.io.PrintWriter;


public class GainBlockEvent extends Event{

	String blockEffect;
	
	public GainBlockEvent(String blockEffect, String repetitions) {
		super(repetitions);
		this.blockEffect = blockEffect;
	}
	
	
	public void generateEvent(PrintWriter writer) {
		if (this.doesRepeat) {
			this.generateRepetition(writer);
		}
		
		
		
		if (this.doesRepeat) {
			System.out.println("}");
		}
	}
	
}

///* 38 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
