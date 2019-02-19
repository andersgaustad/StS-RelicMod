package relics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.megacrit.cardcrawl.rooms.RestRoom;

import helper.RoomLogic;
import relicmod.RelicMod;

public class CampingSupplies extends AbstractRelicModRelic {

	public static final String ID = "Camping_Supplies";
	
	public static final Logger logger = LogManager.getLogger(RelicMod.class.getName());
	
	public CampingSupplies() {
		super(ID, RelicTier.COMMON, LandingSound.HEAVY);
	}
	
	
	@Override
	public void onEquip() {
		RoomLogic.loadNewRoom(new RestRoom());
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0];
	}
	
}
