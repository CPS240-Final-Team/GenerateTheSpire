package events;

import java.io.PrintWriter;


public class UpgradeMagic extends Event{

	String upgradeAmount;
	
	public UpgradeMagic(String upgradeAmount) {
		super("1");
		this.upgradeAmount = upgradeAmount;
	}
	public UpgradeMagic(String upgradeAmount, String repetitions) {
		super(repetitions);
	}
	
	public void generateEvent(PrintWriter writer) {
		if (this.doesRepeat) {
			this.generateRepetition(writer);
		}
		
		writer.println("upgradeBlock(" + upgradeAmount +");");
		
		if (this.doesRepeat) {
			System.out.println("}");
		}
	}
	
}

///* 38 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
