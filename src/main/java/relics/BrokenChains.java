package relics;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class BrokenChains extends AbstractRelicModRelic {

	public static final String ID = "Broken_Chains";
	
	private static final int CARDSDRAWNPEREXHAUST = 1;
	
	// Prevents etheral cards from activating relic
	private boolean playersTurn = true;
	
	
	public BrokenChains() {
		super(ID, RelicTier.RARE, LandingSound.FLAT);
		
	}
	
	@Override
	public void atTurnStart() {
		this.playersTurn = true;
	}
	
	@Override
	public void onExhaust(AbstractCard card) {
		if (this.playersTurn && (cardIsCurse(card) || cardIsStatus(card))) {
			// Relic activates!
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, CARDSDRAWNPEREXHAUST));
		}
	}
	
	@Override
	public void onPlayerEndTurn() {
		this.playersTurn = false;
	}
	
	// Branching in case I change cards drawn per exhaust in the future
	@SuppressWarnings("unused")
	@Override
	public String getUpdatedDescription() {
		String string = DESCRIPTIONS[0];
		
		if (CARDSDRAWNPEREXHAUST<2) {
			string += DESCRIPTIONS[1];
			
		} else {
			string = string + DESCRIPTIONS[2] + CARDSDRAWNPEREXHAUST + DESCRIPTIONS[3];
		}
		
		return string;
	}
	
	private static boolean cardIsStatus(AbstractCard card) {
		return (card.type == AbstractCard.CardType.STATUS);
	}
	
	private static boolean cardIsCurse(AbstractCard card) {
		return (card.type == AbstractCard.CardType.CURSE);
	}
	
	
}
