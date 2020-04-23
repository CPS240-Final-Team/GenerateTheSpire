package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import events.Event;

public class Main {
	
	public static void main (String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		
		PrintWriter writer = new PrintWriter("emptyClass.java", "UTF-8");
		writer.println("public class emptyClass{");
		writer.println("public static void main (String[] args){");
		writer.println("System.out.println(\"Look at me, I'm Incepting!\");");
		writer.println("}");
		writer.println("}");
		writer.close();
	}
	
	//TODO: EVERYTHING
	
	
	
	public void imports(boolean[] isImporting, PrintWriter writer) {
		if (isImporting[0]) {
			writer.println("import com.megacrit.cardcrawl.actions.AbstractGameAction;");
		}
		if (isImporting[1]) {
			writer.println("import com.megacrit.cardcrawl.actions.common.DamageAction;");
		}
		if (isImporting[2]) {
			writer.println("import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;");
		}
		if (isImporting[3]) {
			writer.println("import com.megacrit.cardcrawl.cards.AbstractCard;");
		}
		if (isImporting[4]) {
			writer.println("import com.megacrit.cardcrawl.cards.DamageInfo;");
		}
		if (isImporting[5]) {
			writer.println("import com.megacrit.cardcrawl.characters.AbstractPlayer;");
		}
		if (isImporting[6]) {
			writer.println("import com.megacrit.cardcrawl.core.AbstractCreature;");
		}
		if (isImporting[7]) {
			writer.println("import com.megacrit.cardcrawl.core.CardCrawlGame;");
		}
		if (isImporting[8]) {
			writer.println("import com.megacrit.cardcrawl.core.Settings;");
		}
		if (isImporting[9]) {
			writer.println("import com.megacrit.cardcrawl.dungeons.AbstractDungeon;");
		}
		if (isImporting[10]) {
			writer.println("import com.megacrit.cardcrawl.localization.CardStrings;");
		}
		if (isImporting[11]) {
			writer.println("import com.megacrit.cardcrawl.monsters.AbstractMonster;");
		}
	}
	
	public void declaration(PrintWriter writer,Card_Parameters card) {
		writer.println("public class " + card.id + " extends AbstractCard {");
		writer.println("private static final Cardstring cardStrings = \"" + card.description + "\";");
		writer.println("public static final String ID = \"" + card.id + "\";");
		writer.println("public " + card.id + "() {");
		writer.println("super(\"" + card.id + "\", " + card.name + ", \"" + card.color + "/" + card.cardType + "/" + card.name + "\", " + card.cost + ", " + card.description + ", AbstractCard.CardType." + card.cardType + ", AbstractCard.CardColor." + card.color + ", AbstractCard.CardRarity." + card.rarity + ", AbstractCard.CardTarget." + card.target);
	
		
		if (card.usesDamage) {
			writer.println("this.baseDamage = " + card.damage + ";");
		}
		if (card.usesBlock) {
			writer.println("this.baseBlock = " + card.block + ";");
		}
		if (card.usesMagicNumber) {
			writer.println("this.baseMagicNumber = " + card.magicNumber + ";");
			writer.println("this.magicNumber = this.baseMagicNumber;");
		}
		writer.println("}");
	}
	
	public void createUse(PrintWriter writer,Card_Parameters card) {
		writer.println("public void use(AbstractPlayer p, AbstractMonster m){");
		for (int i=0; i < card.events.length; i++) {
			addEvent(writer, card.events[i]);
		}
		
		
	}
	
	public void addEvent(PrintWriter writer,Event event) {
		
	}
//	/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
//	/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
//	/*    */ import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
//	/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
//	/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
//	/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
//	/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
//	/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
//	/*    */ import com.megacrit.cardcrawl.core.Settings;
//	/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
//	/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
//	/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
	
//	/*    */ public class Strike_Red extends AbstractCard {
//		/* 17 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Strike_R"); public static final String ID = "Strike_R";
//	/*    */   public Strike_Red() {
//		/* 20 */     super("Strike_R", cardStrings.NAME, "red/attack/strike", 1, cardStrings.DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCard.CardColor.RED, AbstractCard.CardRarity.BASIC, AbstractCard.CardTarget.ENEMY);
//		/*    */ 
//		/*    */ 
//		/*    */ 
//		/*    */ 
//		/*    */ 
//		/*    */ 
//		/*    */ 
//		/*    */ 
//		/*    */ 
//		/*    */     
//		/* 31 */     this.baseDamage = 6;
//		/* 32 */     this.tags.add(AbstractCard.CardTags.STRIKE);
//		/* 33 */     this.tags.add(AbstractCard.CardTags.STARTER_STRIKE);
//		/*    */   }
}
