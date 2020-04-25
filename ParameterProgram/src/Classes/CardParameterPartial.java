package Classes;
import Enums.CardColor;
import Enums.CardRarity;
import Enums.CardSpecialEffects;
import Enums.CardType;

//a class who's purpose is to store information from the creation scene for use in the event scene

public class CardParameterPartial 
{
	
	private static String ID;
	private static String cardName;
	private static String cardDescription;
	private static int cardCost;
	private static CardType cardType;
	private static CardSpecialEffects[] cardSpecialEffects;
	//triggers
	private static CardColor cardColor;
	private static CardRarity cardRarity;
	
	public CardParameterPartial(String cID, String cName, String cDescription, int cCost, CardType cType, CardSpecialEffects[] cSpecialEffects, CardColor cColor, CardRarity cRarity)
	{
		this.ID = cID;
		this.cardName = cName;
		this.cardDescription = cDescription;
		this.cardCost = cCost;
		this.cardType = (CardType) cType;
		this.cardSpecialEffects = cSpecialEffects;
		this.cardColor = (CardColor) cColor;
		this.cardRarity = (CardRarity) cRarity;
	}
	
	public static String getID() 
	{
		return ID;
	}

	public static String getCardName() 
	{
		return cardName;
	}

	public static String getCardDescription() 
	{
		return cardDescription;
	}

	public static int getCardCost() 
	{
		return cardCost;
	}

	public static CardType getCardType() 
	{
		return cardType;
	}

	public static CardSpecialEffects[] getCardSpecialEffects()
	{
		return cardSpecialEffects;
	}

	public static CardColor getCardColor() 
	{
		return cardColor;
	}

	public static CardRarity getCardRarity() 
	{
		return cardRarity;
	}

}
