package relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.BufferPower;

public class MagicalSnailShell extends AbstractRelicModRelic {

	private static final String ID = "Magical_Snail_Shell";
	
	private static final int BUFFERSTACKS = 1;
	
	private boolean noCardsPlayed = true;
	
	// Currently uncommen, might nerf to rare
	public MagicalSnailShell() {
		super(ID, RelicTier.UNCOMMON, LandingSound.FLAT);
	}
	
	@Override
	public void atTurnStart() {
		this.noCardsPlayed = true;
		this.beginLongPulse();
	}
	
	@Override
	public void onUseCard(AbstractCard card, UseCardAction action) {
		this.noCardsPlayed = false;
		this.stopPulse();
	}
	
	@Override
	public void onPlayerEndTurn() {
		if (this.noCardsPlayed) {
			// Relic activates!
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new BufferPower(AbstractDungeon.player, BUFFERSTACKS)));
		}
	}
	
}
