package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
	
	public void declaration(String id, PrintWriter writer, String description, int cost, String color, String name, String cardType, String rarity, String target) {
		writer.println("public class " + id + " extends AbstractCard {");
		writer.println("private static final Cardstring cardStrings = \"" + description + "\";");
		writer.println("public static final String ID = \"" + id + "\";");
		writer.println("public " + id + "() {");
		writer.println("super(\"" + id + "\", " + name + ", \"" + color + "/" + cardType + "/" + name + "\", " + cost + ", " + description + ", AbstractCard.CardType." + cardType + ", AbstractCard.CardColor." + color + ", AbstractCard.CardRarity." + rarity + ", AbstractCard.CardTarget." + target);
	}
	
	public void populate() {
		
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
