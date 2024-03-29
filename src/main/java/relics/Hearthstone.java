package relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.FlameBarrierPower;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

public class Hearthstone extends AbstractRelicModRelic {

	public static final String ID = "Hearthstone";
	
	// Buff/nerf?
	private static final int FLAMESPERENERGY = 3;
	
	public Hearthstone() {
		super(ID, RelicTier.COMMON, LandingSound.SOLID);
	}
	
	@Override
	public void atTurnStart() {
		this.beginLongPulse();
	}
	
	@Override
	public void onUseCard(AbstractCard card, UseCardAction action) {
		if ((getPlayerEnergy()-card.cost) == 0) {
			this.stopPulse();
		}
	}
	
	@Override
	public void onPlayerEndTurn() {
		// Activate
		// Relic activates!
		if (getPlayerEnergy()>0) {
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			for (int i=0; i<getPlayerEnergy(); i++) {	
				AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new FlameBarrierPower(AbstractDungeon.player, FLAMESPERENERGY), FLAMESPERENERGY));
				
			}
		}
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + FLAMESPERENERGY + DESCRIPTIONS[1];
	}
	
	private static int getPlayerEnergy() {
		return EnergyPanel.getCurrentEnergy();
		//return AbstractDungeon.player.energy.energy;
	}
	
}
