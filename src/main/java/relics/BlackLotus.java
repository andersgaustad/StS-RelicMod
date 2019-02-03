package relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;


// Grants 3 mana at the start of eac boss battle
// Maybe common relic?
public class BlackLotus extends AbstractRelicModRelic {
	
	public static final String ID = "Black_Lotus";
	
	private static final int blackLotusEnergyGain = 3;
	
	
	public BlackLotus() {
		super(ID, RelicTier.UNCOMMON, LandingSound.MAGICAL);
	}
	
	
	@Override
	public void atBattleStart() {
		super.atBattleStart();
		
		for (AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
			if (monster.type == AbstractMonster.EnemyType.BOSS) {
				// Relic activates!
				this.flash();
				AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
				AbstractDungeon.player.gainEnergy(blackLotusEnergyGain);
				return;
			}
		}
		
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0];
	}
}
