package relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import helper.MonsterLogic;

public class ParryingDagger extends AbstractRelicModRelic {

	public static final String ID = "Parrying_Dagger";
	
	private static final int REQUIREDBLOCK = 10;
	private static final int STACKSOFWEAK = 1;
	
	public ParryingDagger() {
		super(ID, RelicTier.UNCOMMON, LandingSound.FLAT);
	}
	
	
	@Override
	public void onPlayerEndTurn() {
		if (AbstractDungeon.player.currentBlock>=REQUIREDBLOCK) {
			for (AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
				if (MonsterLogic.monsterIntendsToAttack(monster)) {
					// Relics activates!
					this.flash();
					AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
					
					// Test if this works
					AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(monster, AbstractDungeon.player, new WeakPower(monster, STACKSOFWEAK, false)));
				}
			}
		}
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + REQUIREDBLOCK + DESCRIPTIONS[1] + STACKSOFWEAK + DESCRIPTIONS[2];
	}
	
	
}
