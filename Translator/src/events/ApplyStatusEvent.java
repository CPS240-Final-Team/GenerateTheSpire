package events;

import java.io.PrintWriter;


public class ApplyStatusEvent extends Event{
	
	String statusEffect;

	//How many of the status effect is applied.
	int stacks;
	
	//p means player, m means monster, a means all enemies.
	char target;
	
	public ApplyStatusEvent(String statusEffect, String repetitions) {
		super(repetitions);
		this.statusEffect = statusEffect;
	}
	
	public void generateEvent(PrintWriter writer) {
		if (this.doesRepeat) {
			this.generateRepetition(writer);
		}

		if (target!= 'a') {
			
		} else {
			
		}
		
		
		if (this.doesRepeat) {
			System.out.println("}");
		}
	}
	
}
