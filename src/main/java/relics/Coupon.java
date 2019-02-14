package relics;

import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.ShopRoom;

public class Coupon extends AbstractRelicModRelic {

	public static final String ID = "Coupon";
	
	private static final int REQUIREDPURCHASES = 5;
	private static final int FLOORSPAWNLIMIT = 30;
	
	public Coupon() {
		super(ID, RelicTier.COMMON, LandingSound.FLAT);
		this.counter = 0;
		
	}
	
	
	@Override
	public boolean canSpawn() {
		return (super.canSpawn() && AbstractDungeon.floorNum<FLOORSPAWNLIMIT && !Settings.isEndless);
	}
	
	@Override
	public void onEnterRoom(AbstractRoom room) {
		checkPulseConditions();
	}
	
	@Override
	public void onSpendGold() {
		this.counter++;
		checkPulseConditions();
		if (this.counter>=REQUIREDPURCHASES) {
			// Relic activates!
			this.flash();
			
			AbstractDungeon.getCurrRoom().rewards.add(new RewardItem(AbstractDungeon.returnRandomRelic(AbstractDungeon.returnRandomRelicTier())));
			AbstractDungeon.combatRewardScreen.open();
			
			this.counter = 0;
		}
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + REQUIREDPURCHASES + DESCRIPTIONS[1];
	}
	
	
	private void checkPulseConditions() {
		if (freeStuffImminent()) {
			this.beginLongPulse();
			
		} else {
			this.stopPulse();
		}
	}
	
	private boolean freeStuffImminent() {
		return (this.counter == (REQUIREDPURCHASES-1)) && (AbstractDungeon.getCurrRoom() instanceof ShopRoom); 
	}
	
}
