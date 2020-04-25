package Classes;
import Enums.CardColor;
import Enums.CardRarity;
import Enums.CardSpecialEffects;
import Enums.CardType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CardParameters 
{

	private boolean[] isImporting;
	private static String ID;
	private static String target;
	private static String cardName;
	private static String cardDescription;
	private static int cardCost;
	private static CardType cardType;
	private static CardSpecialEffects[] cardSpecialEffects;
	private static CardColor cardColor;
	private static CardRarity cardRarity;
	
	private boolean usesBlock;
	private boolean usesMagicNumber;
	private boolean usesDamage;
	
	private int magicNumber;
	private int block;
	private int damage;
	//private EventGroup[] eventGroups;					can't import eventGroups?????
	
	public CardParameters(String cID, String cName, String cDescription, int cCost, CardType cType, CardSpecialEffects[] cSpecialEffects, CardColor cColor, CardRarity cRarity, boolean useBlock, boolean useMagicNumber, boolean useDamage, int magicNumber, int blockNumber, int damageNumber)
	{	
		this.ID = cID;
		this.cardName = cName;
		this.cardDescription = cDescription;
		this.cardCost = cCost;
		this.cardType = cType;
		this.cardSpecialEffects = cSpecialEffects;
		this.cardColor = cColor;
		this.cardRarity = cRarity;
		this.usesBlock = useBlock;
		this.usesMagicNumber = usesMagicNumber;
		this.usesDamage = usesDamage;
		
		if(!useBlock)
		{
			this.block = 0;
		}
		else
		{
			this.block = magicNumber;
		}
		
		if(!useMagicNumber)
		{
			this.magicNumber = 0;
		}
		else
		{
			this.magicNumber = magicNumber;
		}
		
		if(!usesDamage)
		{
			this.damage = 0;
		}
		else
		{
			this.damage = damageNumber;
		}
		
	}
	
}
