package relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.evacipated.cardcrawl.mod.stslib.relics.OnChannelRelic;

public class OrbOptimizer extends AbstractRelicModRelic implements OnChannelRelic {

	public static final String ID = "Orb_Optimizer";
	
	private static final int EVOKES = 2;
	
	public OrbOptimizer() {
		super(ID, RelicTier.UNCOMMON, LandingSound.FLAT);
	}

	@Override
	public void onChannel(AbstractOrb arg0) {
		AbstractPlayer player = AbstractDungeon.player;
		if (player.orbs.size()==player.maxOrbs) {
			// We are at max orbs
			// Relic activates
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			for (int i=0; i<(EVOKES-1); i++) {
				player.evokeWithoutLosingOrb();
			}
			
			player.evokeOrb();
			
		}
		
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + EVOKES + DESCRIPTIONS[1];
	}
	
	
	
	
	
	
	
}
