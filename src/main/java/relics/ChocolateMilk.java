package relics;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.MonsterRoom;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import com.megacrit.cardcrawl.rooms.MonsterRoomElite;

public class ChocolateMilk extends AbstractRelicModRelic {

	public static final String ID = "Chocolate_Milk";
	
	private static final int HEALINGAMOUNT = 2;
	
	public ChocolateMilk() {
		super(ID, RelicTier.COMMON, LandingSound.CLINK);
	}
	
	
	@Override
	public void onEnterRoom(AbstractRoom room) {
		if (!((room instanceof MonsterRoom) || (room instanceof MonsterRoomElite) || (room instanceof MonsterRoomBoss))) {
			this.flash();
			
			AbstractDungeon.player.heal(HEALINGAMOUNT);
		}
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + HEALINGAMOUNT + DESCRIPTIONS[1];
	}
	
}
