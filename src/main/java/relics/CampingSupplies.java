package relics;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.MapEdge;
import com.megacrit.cardcrawl.map.MapRoomNode;
import com.megacrit.cardcrawl.rooms.RestRoom;

import relicmod.RelicMod;

public class CampingSupplies extends AbstractRelicModRelic {

	public static final String ID = "Camping_Supplies";
	
	public static final Logger logger = LogManager.getLogger(RelicMod.class.getName());
	
	public CampingSupplies() {
		super(ID, RelicTier.COMMON, LandingSound.HEAVY);
	}
	
	
	@Override
	public void onEquip() {
		MapRoomNode currentMapNode = AbstractDungeon.currMapNode;
		
		if (currentMapNode==null) {
			logger.info("Warning: Could not get current room for creating RestRoom on CampfireSupplies equip. Is map initalized?");
			return;
		}
		
		MapRoomNode nextNode = new MapRoomNode(currentMapNode.x, currentMapNode.y);
		nextNode.room = new RestRoom();
		
		List<MapEdge> edges = currentMapNode.getEdges();
		for (MapEdge edge : edges) {
			nextNode.addEdge(edge);
		}
		
		AbstractDungeon.nextRoom = nextNode;
		AbstractDungeon.nextRoomTransitionStart();
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0];
	}
	
}
