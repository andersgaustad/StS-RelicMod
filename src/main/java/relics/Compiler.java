package relics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;

public class Compiler extends AbstractRelicModRelic {
	
	public static final String ID = "Compiler";

	public Compiler() {
		super(ID, RelicTier.RARE, LandingSound.HEAVY);
	}
	
	
	@Override
	public void atTurnStartPostDraw() {
		Collection<AbstractOrb> orbs = AbstractDungeon.player.orbs;
		Collection<String> orbTypes = new ArrayList<String>(orbs.size());
		
		for (AbstractOrb orb : orbs) {
			orbTypes.add(orb.ID);
		}
		
		
		int cardsToDraw = new HashSet<String>(orbTypes).size();
		
		if (cardsToDraw>0) {
			// Relic activates!
			this.flash();
			AbstractDungeon.actionManager.addToTop(new DrawCardAction(AbstractDungeon.player, cardsToDraw));
		}
		
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0];
	}
	
	
	
}
