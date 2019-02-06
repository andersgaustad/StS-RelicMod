package relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.ArtifactPower;

public class AncientShield extends AbstractRelicModRelic {

	public final static String ID = "Ancient_Shield";
	
	private final static int STACKSOFARTIFACT = 1;
	
	private boolean onlySkillsUsed = true;
	
	public AncientShield() {
		super(ID, RelicTier.COMMON, LandingSound.HEAVY);
		
	}
	
	
	@Override
	public void atTurnStart() {
		this.onlySkillsUsed = true;
		this.beginPulse();
	}
	
	@Override
	public void onUseCard(AbstractCard card, UseCardAction action) {
		if (card.type != AbstractCard.CardType.SKILL) {
			this.onlySkillsUsed = false;
			this.stopPulse();
		}
	}
	
	@Override
	public void onPlayerEndTurn() {
		if (this.onlySkillsUsed) {
			// Relic activates!
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			AbstractDungeon.player.addPower(new ArtifactPower(AbstractDungeon.player, STACKSOFARTIFACT));
			
		}
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + STACKSOFARTIFACT + DESCRIPTIONS[1];
	}
	
	
}
