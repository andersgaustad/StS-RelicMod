package relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardColor;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ForgottenJournal extends AbstractRelicModRelic {

	public static final String ID = "ForgottenJournal";
	
	private CardColor color;
	
	public ForgottenJournal() {
		super(ID, RelicTier.SHOP, LandingSound.FLAT);
	}
	
	
	@Override
	public void onEquip() {
		this.color = AbstractDungeon.player.getCardColor();
	}
	
	
	@Override
	public void onUseCard(AbstractCard card, UseCardAction usecardaction) {
		if (card.color!=this.color) {
			// Relic activates!
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			AbstractDungeon.player.gainEnergy(card.costForTurn);
			
		}
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + String.valueOf(AbstractDungeon.player.getCardColor()) + DESCRIPTIONS[1];
	}
}
