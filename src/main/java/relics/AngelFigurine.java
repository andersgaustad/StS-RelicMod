package relics;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.Apotheosis;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class AngelFigurine extends AbstractRelicModRelic {

	public static final String ID = "Angel_Figurine";
	
	private boolean active = true;
	
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
	
	
	private void activate() {
		setActive(true);
	}
	
	private void deactivate() {
		setActive(false);
	}
	
	private void setActive(boolean activate) {
		// XOR; Same as: this.active!=activate
		if (this.active ^ activate) {
			this.active = activate;
			
			this.img = AbstractRelicModRelic.getRelicTexture(ID, activate);
		}
	}
}
