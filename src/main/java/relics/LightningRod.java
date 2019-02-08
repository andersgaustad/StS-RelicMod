package relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class LightningRod extends AbstractRelicModRelic {

	public static final String ID = "Lightning_Rod";
	private boolean firstCardThisTurn = true;
	
	
	public LightningRod() {
		super(ID, RelicTier.SHOP, LandingSound.CLINK);
		
	}
	
	@Override
	public void onUseCard(AbstractCard card, UseCardAction action) {
		if (this.firstCardThisTurn && (card.cost == -1) && (!card.purgeOnUse)) {
			// Relic activates!
			this.flash();
			
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			// Exhaust, might be too OP else
			card.exhaust = true;
			
			AbstractMonster monster = null;
			
			if (action.target != null) {
				monster = (AbstractMonster) action.target;
			}
			
			AbstractCard copy = card.makeSameInstanceOf();
			copy.current_x = card.current_x;
			copy.current_y = card.current_y;
			copy.target_x = (Settings.WIDTH / 2.0F - 300.0F * Settings.scale);
			copy.target_y = (Settings.HEIGHT / 2.0F);
			copy.freeToPlayOnce = true;
			copy.applyPowers();
			copy.purgeOnUse = true;
			AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(copy, monster));
		}
		
		this.stopPulse();
		this.firstCardThisTurn = false;
	}
	
	@Override
	public void atTurnStart() {
		this.firstCardThisTurn = true;
		this.beginPulse();
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0];
	}
	
	
}
