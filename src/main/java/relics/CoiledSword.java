package relics;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.RestRoom;

public class CoiledSword extends AbstractRelicModRelic {
	
	public static final String ID = "Coiled_Sword";
	
	private static final int HPPERCOUNTER = 1;
	private static final int GOLDPERCOUNTER = 6;
	
	public CoiledSword() {
		super(ID, RelicTier.COMMON, LandingSound.CLINK);
		this.counter = 0;
	}
	
	@Override
	public void onEnterRoom(AbstractRoom room) {
		this.flash();
		this.counter++;
		
		if (room instanceof RestRoom) {
			AbstractDungeon.player.heal(this.counter*HPPERCOUNTER);
			AbstractDungeon.player.gainGold(this.counter*GOLDPERCOUNTER);
			
			this.counter = 0;
		}
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + String.valueOf(HPPERCOUNTER) + DESCRIPTIONS[1] + String.valueOf(GOLDPERCOUNTER) + DESCRIPTIONS[2];
	}
	

}
