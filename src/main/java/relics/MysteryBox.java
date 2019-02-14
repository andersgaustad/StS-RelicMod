package relics;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rewards.RewardItem;

public class MysteryBox extends AbstractRelicModToggleRelic {

	public static final String ID = "Mystery_Box";
	
	private String relicGiftName = "";
	
	public MysteryBox() {
		super(ID, RelicTier.SHOP, LandingSound.FLAT);
	}
	
	
	@Override
	public void onEquip() {
		AbstractRelic reward = AbstractDungeon.returnRandomRelic(AbstractDungeon.returnRandomRelicTier());
		AbstractDungeon.getCurrRoom().rewards.add(new RewardItem(reward));
		setRelicGiftName(reward.name);
		AbstractDungeon.combatRewardScreen.open();
		
		this.deactivate();
	}
	
	@Override
	public String getUpdatedDescription() {
		String finalDescription;
		if (this.active) {
			finalDescription = DESCRIPTIONS[0];
			
		} else {
			finalDescription = DESCRIPTIONS[1] + this.relicGiftName + DESCRIPTIONS[2];
			
		}
		
		return finalDescription;
	}
	
	
	private final void setRelicGiftName(String name) {
		this.relicGiftName = name;
	}
	
}
