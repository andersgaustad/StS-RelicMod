package relics;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.Apotheosis;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class AngelFigurine extends AbstractRelicModToggleRelic {

	public static final String ID = "Angel_Figurine";
	
	
	public AngelFigurine() {
		super(ID, RelicTier.RARE, LandingSound.MAGICAL);
		
	}
	
	
	// To prevent mystic bugs caused by onVictory not calling (like smoke bomb?)
	@Override
	public void atBattleStart() {
		this.activate();
	}
	
	@Override
	public void onCardDraw(AbstractCard drawnCard) {
		if (this.active && (drawnCard.type == AbstractCard.CardType.CURSE)) {
			// Relic activates (once)!
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			this.deactivate();
			AbstractDungeon.player.hand.moveToDiscardPile(drawnCard);
			AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(new Apotheosis()));
		}
	}
	
	
	@Override
	public void onVictory() {
		this.activate();
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0];
	}
	

}
