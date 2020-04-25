package events;

import java.io.PrintWriter;


public class DamageTargetMonsterEvent extends Event{
	//Possible effects:
	//BLUNT_LIGHT, BLUNT_HEAVY, SLASH_DIAGONAL, SMASH, SLASH_HEAVY, SLASH_HORIZONTAL, SLASH_VERTICAL, NONE, FIRE, POISON, SHIELD, LIGHTNING
	String attackEffect;
	
	char target;
	
	
	public DamageTargetMonsterEvent(String attackEffect, char target) {
		super("1");
		this.attackEffect = attackEffect;
		this.target = target;
	}
	
	public DamageTargetMonsterEvent(String attackEffect, String repetitions, char target) {
		super(repetitions);
		this.attackEffect = attackEffect;
		this.target = target;
	}
	
	public void generateEvent(PrintWriter writer) {
		if (this.doesRepeat) {
			this.generateRepetition(writer);
		}
		
		writer.println("addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p,this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect." + this.attackEffect + "));)");
		
		
		
		if (this.doesRepeat) {
			System.out.println("}");
		}
	}
	
}
