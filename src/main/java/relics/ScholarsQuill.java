package relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class ScholarsQuill extends AbstractRelicModRelic {

	public static final String ID = "Scholar's_Quill";
	
	private static final int STRENGTHBOOST = 1;
	
	private boolean playersTurn = false;
	
	public ScholarsQuill() {
		super(ID, RelicTier.COMMON, LandingSound.FLAT);
	}
	
	
	@Override
	public void atTurnStart() {
		this.playersTurn = false;
	}
	
	// This doesn't work??
	/*
	@Override 
	public void atTurnStartPostDraw() {
		this.playersTurn = true;
	}
	*/
	
	@Override
	public void onCardDraw(AbstractCard drawnCard) {
		if (this.playersTurn) {
			// Relic activates!
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, STRENGTHBOOST), STRENGTHBOOST));      
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new LoseStrengthPower(AbstractDungeon.player, STRENGTHBOOST), STRENGTHBOOST));	
		}
		
	}
	
	// Workaround
	@Override
	public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
		this.playersTurn = true;
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + STRENGTHBOOST + DESCRIPTIONS[1];
	}
	
}
