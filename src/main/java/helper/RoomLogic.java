package helper;

import java.util.List;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.MapEdge;
import com.megacrit.cardcrawl.map.MapRoomNode;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

public class RoomLogic {

	public static void resetCurrentRoom() {
		loadNewRoom(AbstractDungeon.getCurrRoom());
	}
	
	public static void loadNewRoom(AbstractRoom newRoom) {
		MapRoomNode currentMapNode = AbstractDungeon.getCurrMapNode();
		
		MapRoomNode nextNode = new MapRoomNode(currentMapNode.x, currentMapNode.y);
		nextNode.room = newRoom;
		
		List<MapEdge> edges = currentMapNode.getEdges();
		for (MapEdge edge : edges) {
			nextNode.addEdge(edge);
		}
		
		AbstractDungeon.nextRoom = nextNode;
		AbstractDungeon.nextRoomTransitionStart();
	}
	
}
