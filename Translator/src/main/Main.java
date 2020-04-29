package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import card.Card_Parameters;
import eventGroups.EventGroup;
import eventGroups.EventGroupUse;
import events.DamageTargetMonsterEvent;
import events.Event;
import events.GainBlockEvent;

public class Main {

	public static void main (String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		//		public Card_Parameters(boolean[] isImporting, String id, String target, String rarity, String color,
		//				String cardType, String description, String name, boolean usesBlock, boolean usesMagicNumber,
		//				boolean usesDamage, int cost, int magicNumber, int block, int damage, Event[] events) 

		Event[] ironWaveEvents = new Event[2];
		ironWaveEvents[0] = new GainBlockEvent();
		ironWaveEvents[1] = new DamageTargetMonsterEvent("SLASH_VERTICAL", 'm');

		EventGroupUse useCasesIronWave = new EventGroupUse(ironWaveEvents);
				
		EventGroup[] eventGroupsIronWave = new EventGroup[1];

		eventGroupsIronWave[0] = useCasesIronWave;

		Card_Parameters card = new Card_Parameters(null, "iron_wave", "ENEMY", "COMMON", "RED", "ATTACK", "Gain %b block, deal %d damage", "Iron Wave", true, true, false, 1, 5, 5, 0, eventGroupsIronWave);

		PrintWriter writer = new PrintWriter("emptyClass.java", "UTF-8");

		createCard(writer, card);



		writer.close();
	}

	//TODO: EVERYTHING


	public static void createCard(PrintWriter writer, Card_Parameters card) {
		imports(writer, card);
		declaration(writer, card);
		for (int i=0; i<card.eventGroups.length; i++) {
			card.eventGroups[i].createUseCase(writer);
		}
		
		makeCopy(writer,card);
		
	}
	
	public static void makeCopy(PrintWriter writer, Card_Parameters card) {
		
		writer.println("public AbstractCard makeCopy() {");
		writer.println("return new " + card.id + "();");
		writer.println("}");
	}


	public static void imports(PrintWriter writer, Card_Parameters card) {
		if(card.isImporting!=null) {
			if (card.isImporting[0]) {
				writer.println("import com.megacrit.cardcrawl.actions.AbstractGameAction;");
			}
			if (card.isImporting[1]) {
				writer.println("import com.megacrit.cardcrawl.actions.common.DamageAction;");
			}
			if (card.isImporting[2]) {
				writer.println("import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;");
			}
			if (card.isImporting[3]) {
				writer.println("import com.megacrit.cardcrawl.cards.AbstractCard;");
			}
			if (card.isImporting[4]) {
				writer.println("import com.megacrit.cardcrawl.cards.DamageInfo;");
			}
			if (card.isImporting[5]) {
				writer.println("import com.megacrit.cardcrawl.characters.AbstractPlayer;");
			}
			if (card.isImporting[6]) {
				writer.println("import com.megacrit.cardcrawl.core.AbstractCreature;");
			}
			if (card.isImporting[7]) {
				writer.println("import com.megacrit.cardcrawl.core.CardCrawlGame;");
			}
			if (card.isImporting[8]) {
				writer.println("import com.megacrit.cardcrawl.core.Settings;");
			}
			if (card.isImporting[9]) {
				writer.println("import com.megacrit.cardcrawl.dungeons.AbstractDungeon;");
			}
			if (card.isImporting[10]) {
				writer.println("import com.megacrit.cardcrawl.localization.CardStrings;");
			}
			if (card.isImporting[11]) {
				writer.println("import com.megacrit.cardcrawl.monsters.AbstractMonster;");
			}
		}
	}


	public static void declaration(PrintWriter writer,Card_Parameters card) {
		writer.println("public class " + card.id + " extends AbstractCard {");
		writer.println("private static final Cardstring cardStrings = \"" + card.description + "\";");
		writer.println("public static final String ID = \"" + card.id + "\";");
		writer.println("public " + card.id + "() {");
		writer.println("super(\"" +card.id +"\", \"" + card.name + "\", \"" + card.color + "/" + card.cardType + "/" + card.name + "\", " + card.cost + ", " + "\"" + card.description + "\""+ ", AbstractCard.CardType." + card.cardType + ", AbstractCard.CardColor." + card.color + ", AbstractCard.CardRarity." + card.rarity + ", AbstractCard.CardTarget." + card.target + ");");


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
