package relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class AssassinsTools extends AbstractRelicModRelic {

	public static final String ID = "Assassin's_Tools";
	
	private static final int POISONCOUNT = 2;
	
	public AssassinsTools() {
		super(ID, RelicTier.SHOP, LandingSound.CLINK);
	}
	
	
	@Override
	public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
		if (targetCard.upgraded) {
			// Relic activates:
			this.flash();
			
			for (AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
				AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(monster, AbstractDungeon.player, new PoisonPower(monster, AbstractDungeon.player, POISONCOUNT), POISONCOUNT));
				
			}
			
		}
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + POISONCOUNT + DESCRIPTIONS[1];
	}
	
}
