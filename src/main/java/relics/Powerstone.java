package relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.red.Berserk;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.BerserkPower;

public class Powerstone extends AbstractRelicModRelic {

	public final static String ID = "Powerstone";
	
	private final static int POWERCARDSREQUIRED = 2;
	private final static int POWERPROVIDED = 1;
	
	
	public Powerstone() {
		super(ID, RelicTier.SHOP, LandingSound.MAGICAL);
	}
	
	
	@Override
	public void onUseCard(AbstractCard card, UseCardAction action) {
		// Check if card is power:
		if (card.type == AbstractCard.CardType.POWER) {
			// Increment counter:
			this.counter++;
			if (this.counter % POWERCARDSREQUIRED == 0) {
				// Relic activates!
				this.counter = 0;
				this.flash();
				
				AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
				
				// Add energy buff from berserk
				AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new BerserkPower(Berserk.DESCRIPTION, AbstractDungeon.player, POWERPROVIDED)));
			}
			
			
		}
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + String.valueOf(POWERCARDSREQUIRED) + DESCRIPTIONS[1];
	}
	
	
}
