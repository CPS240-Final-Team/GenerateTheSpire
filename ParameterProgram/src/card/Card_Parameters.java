package card;

import eventGroups.EventGroup;

public class Card_Parameters {
	
	public Card_Parameters(boolean[] isImporting, String id, String target, String rarity, String color,
			String cardType, String description, String name, boolean usesBlock, boolean usesMagicNumber,
			boolean usesDamage, int cost, int magicNumber, int block, int damage, EventGroup[] eventGroups) {
		
		super();
		this.isImporting = isImporting;
		this.id = id;
		this.target = target;
		this.rarity = rarity;
		this.color = color;
		this.cardType = cardType;
		this.description = description;
		this.name = name;
		this.usesBlock = usesBlock;
		this.usesMagicNumber = usesMagicNumber;
		this.usesDamage = usesDamage;
		this.cost = cost;
		this.magicNumber = magicNumber;
		this.block = block;
		this.damage = damage;
		this.eventGroups = eventGroups;
	}

	public boolean[] isImporting;

	public String id;
	public String target;
	public String rarity;
	public String color;
	public String cardType;
	public String description;
	public String name;

	public boolean usesBlock;
	public boolean usesMagicNumber;
	public boolean usesDamage;
	
	public int cost;
	public int magicNumber;
	public int block;
	public int damage;
	
	public EventGroup[] eventGroups;
	

}
