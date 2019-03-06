package relics;

import com.evacipated.cardcrawl.mod.stslib.relics.BetterOnSmithRelic;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;

public class SigiledHammer extends AbstractRelicModRelic implements BetterOnSmithRelic {

	public static final String ID = "Sigiled_Hammer";
	
	private static final int COPIES = 2;
	
	public SigiledHammer() {
		super(ID, RelicTier.SHOP, LandingSound.SOLID);
	}

	@Override
	public void betterOnSmith(AbstractCard arg0) {
		// Relic activates!
		this.flash();
		
		AbstractCard[] copiedCards = new AbstractCard[COPIES];
		
		for (int i=0; i<COPIES; i++) {
			copiedCards[i] = arg0.makeCopy();
			copiedCards[i].upgrade();
		
			// Check that this works:
			AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(copiedCards[i], Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F));
		}
		
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + COPIES + DESCRIPTIONS[1];
	}
}
