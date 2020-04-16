import Enums.CardColor;
import Enums.CardRarity;
import Enums.CardSpecialEffects;
import Enums.CardType;

public class CardParameters 
{

	public static String ID;
	public static String cardName;
	public static String cardDescription;
	public static int cardCost;
	public static CardType cardType;
	public static CardSpecialEffects[] cardSpecialEffects;
	//triggers
	public static CardColor cardColor;
	public static CardRarity cardRarity;
	
	public CardParameters(String cName, String cDescription, int cCost, Object cType, CardSpecialEffects[] cSpecialEffects, Object cColor, Object cRarity)
	{
		this.cardName = cName;
		this.cardDescription = cDescription;
		this.cardCost = cCost;
		this.cardType = (CardType) cType;
		this.cardSpecialEffects = cSpecialEffects;
		this.cardColor = (CardColor) cColor;
		this.cardRarity = (CardRarity) cRarity;
	}
	
}
