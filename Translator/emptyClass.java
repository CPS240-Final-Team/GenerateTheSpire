public class iron_wave extends AbstractCard {
private static final Cardstring cardStrings = "Gain %b block, deal %d damage";
public static final String ID = "iron_wave";
public iron_wave() {
super("iron_wave", "Iron Wave", "RED/ATTACK/Iron Wave", 1, "Gain %b block, deal %d damage", AbstractCard.CardType.ATTACK, AbstractCard.CardColor.RED, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
this.baseBlock = 5;
this.baseMagicNumber = 5;
this.magicNumber = this.baseMagicNumber;
}
public void use(AbstractPlayer p, AbstractMonster m){
addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p,this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));)
}
public void upgrade() {
if (!this.upgraded) {
upgradeBlock(2);
upgradeDamage(2);
}
}
public AbstractCard makeCopy() {
return new iron_wave();
}
