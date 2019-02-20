package relics;

import com.evacipated.cardcrawl.mod.stslib.relics.OnAfterUseCardRelic;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import helper.RandomLogic;

public class StuffedToySnake extends AbstractRelicModRelic implements OnAfterUseCardRelic {

	public static final String ID = "Stuffed_Toy_Snake";
	
	private static final int CARDCOSTLIMIT = 2;
	
	private static final int LOWESTCOST = 0;
	private static final int HIGHESTCOST = 3;
	
	
	public StuffedToySnake() {
		super(ID, RelicTier.RARE, LandingSound.MAGICAL);
	}

	
	@Override
	public void onUseCard(AbstractCard card, UseCardAction usecardaction) {
		if (cardCostAtLeast(card, CARDCOSTLIMIT)) {
			// Show relic activation:
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			// Actual logic happens in onAfterUseCard
		}
	}
	
	@Override
	public void onAfterUseCard(AbstractCard arg0, UseCardAction arg1) {
		if (cardCostAtLeast(arg0, CARDCOSTLIMIT)) {
			// Relic logic happens
			
			int newCost = RandomLogic.getRandomNumber(LOWESTCOST, HIGHESTCOST + 1);
			arg0.modifyCostForCombat(newCost);
		}
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + CARDCOSTLIMIT + DESCRIPTIONS[1];
	}
	
	
	private static boolean cardCostAtLeast(AbstractCard card, int limit) {
		int cost = card.cost;
		
		boolean ret = cost>=limit;
		
		if (cost==-1) {
			ret = true;
		}
		
		return ret;
	}
	
}
