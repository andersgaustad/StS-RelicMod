package relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class SwordOfVigilance extends AbstractRelicModRelic {

	public static final String ID = "Sword_of_Vigilance";
	
	private static final int BLOCKPERSTRIKE = 2;
	
	public SwordOfVigilance() {
		super(ID, RelicTier.COMMON, LandingSound.CLINK);
	}
	
	@Override
	public void onUseCard(AbstractCard card, UseCardAction action) {
		if (isBasicStrike(card)) {
			// Relic activates!
			this.flash();
			// Disable RelicAboveCreature to prevent spam?
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			AbstractDungeon.player.addBlock(BLOCKPERSTRIKE);
			
		}
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + BLOCKPERSTRIKE + DESCRIPTIONS[1];
	}
	
	private static boolean isBasicStrike(AbstractCard card) {
		return (card.hasTag(AbstractCard.CardTags.STRIKE) && (card.rarity == AbstractCard.CardRarity.BASIC));
	}
	
}
