package relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import helper.Helper;

public class WantedPoster extends AbstractRelicModRelic {
	
	public static final String ID = "Wanted_Poster";
	
	private static final int BOUNTY = 100;
	private static final int VULNERABLEDURATION = 2;
	
	
	public WantedPoster() {
		super(ID, RelicTier.BOSS, LandingSound.CLINK);
		
	}
	
	
	@Override
	public void atBattleStart() {
		// Apply vulnerable to each elite and boss
		for (AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
			if (Helper.enemyIsElite(monster) || Helper.enemyIsBoss(monster)) {
				// Relic activates
				this.flash();
				AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
				AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(monster, AbstractDungeon.player, new VulnerablePower(monster, VULNERABLEDURATION, false), 1, true));
			}
		}
	}
	
	
	@Override
	public void onMonsterDeath(AbstractMonster m) {
		
		// Is enemy dead (and was enemy elite or boss)?
		if ((m.currentHealth == 0) && (Helper.enemyIsElite(m) || Helper.enemyIsBoss(m))) {
			// Relic activates
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			AbstractDungeon.player.gainGold(BOUNTY);
		}
		
	}
	
	@Override
	public String getUpdatedDescription() {
	     return this.DESCRIPTIONS[0] + VULNERABLEDURATION + this.DESCRIPTIONS[1] + BOUNTY + this.DESCRIPTIONS[2];
	}
	
	
	
}
