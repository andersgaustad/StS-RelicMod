package relics;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import basemod.abstracts.CustomRelic;
import relicmod.RelicMod;

// Grants 3 mana at the start of eac boss battle
public class BlackLotus extends CustomRelic {
	
	public static final String ID = "BlackLotus";
	
	
	public BlackLotus() {
		super(ID, RelicMod.getRelicTexture(ID), RelicTier.UNCOMMON, LandingSound.MAGICAL);
	}
	
	
	@Override
	public void atBattleStartPreDraw() {
		super.atBattleStartPreDraw();
		
		// Need to check if enemy is boss
		// Should decompile
		/*
		if (AbstractDungeon.getCurrRoom().RoomType() {
			
		}
		*/
	}
}
