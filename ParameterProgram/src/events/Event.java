package events;

import java.io.PrintWriter;


public abstract class Event {
	boolean doesRepeat;

	//If repetitions are "magic number", the string should be "this.magicNumber"
	String repetitions;
	
	//p means player, m means monster, a means all enemies, r means random enemy
	char target;

	public Event(String repetitions) {
		if (repetitions != "1") {
			doesRepeat = true;
		} else {
			doesRepeat = false;
		}
	}
	
	public void generateEvent(PrintWriter writer) {
		
	}
	
	
	public void generateRepetition(PrintWriter writer) {
		if (doesRepeat) {
			writer.println("for (int i=0; i < " + repetitions + "; i++) {");
		}
	}
}
