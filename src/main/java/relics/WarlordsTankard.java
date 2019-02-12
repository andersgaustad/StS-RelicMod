package relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import helper.MonsterLogic;

public class WarlordsTankard extends AbstractRelicModRelic {

	public static final String ID = "Warlord's_Tankard";
	
	// Comparable to Meat on the Bone
	private static final int HPHEALED = 12;
	
	private boolean eliteCombat = false;
	
	public WarlordsTankard() {
		super(ID, RelicTier.UNCOMMON, LandingSound.SOLID);
	}
	
	@Override
	public void atBattleStart() {
		this.eliteCombat = false;
		for (AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
			if (MonsterLogic.enemyIsElite(monster)) {
				this.eliteCombat = true;
				return;
			}
		}
	}
	
	@Override
	public void onVictory() {
		if (this.eliteCombat && AbstractDungeon.player.currentHealth > 0) {
			// Relic activates
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			AbstractDungeon.player.heal(HPHEALED);
			
		}
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + HPHEALED + DESCRIPTIONS[1];
	}
	
}
