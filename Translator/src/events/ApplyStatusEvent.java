package events;

import java.io.PrintWriter;


public class ApplyStatusEvent extends Event{

	
	//
	String statusEffect;

	//How many of the status effect is applied.
	String stacks;
	
	//p is for player, m is for enemy, r is for random enemy, a is for all enemies.
	char target;
	
	
	public ApplyStatusEvent(String statusEffect, char target, String stacks) {
		super("1");
		this.statusEffect = statusEffect;
		this.target = target;
		this.stacks = stacks;
	}
	public ApplyStatusEvent(String statusEffect, char target, String stacks, String repetitions) {
		super(repetitions);
		this.statusEffect = statusEffect;
		this.target = target;
		this.stacks = stacks;
	}
	
	public void generateEvent(PrintWriter writer) {
		if (this.doesRepeat) {
			this.generateRepetition(writer);
		}
		
		if (target == 'a') {
			writer.println("for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {");
		}
		
		writer.println("addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)" + target + ", (AbstractCreature)p, (AbstractPower)new " + statusEffect + "((AbstractCreature)p, " + stacks + "), " + stacks +"));");
		
		if (target == 'a') {
			writer.println("}");
		}
		if (this.doesRepeat) {
			System.out.println("}");
		}
	}
	
}
