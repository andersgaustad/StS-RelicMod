package relics;

import com.evacipated.cardcrawl.mod.stslib.relics.BetterOnSmithRelic;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.MetallicizePower;

public class HeartOfSteel extends AbstractRelicModRelic implements BetterOnSmithRelic {
	
	public static final String ID = "Heart_of_Steel";
	
	private static final int STARTBLOCK = 2;
	private static final int BLOCKPERSMITH = 2;
	
	public HeartOfSteel() {
		super(ID, RelicTier.RARE, LandingSound.HEAVY);
		this.counter = STARTBLOCK;
	}
	
	
	@Override
	public void atBattleStart() {
		// Relics activates
		this.flash();
		
		AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, null, new MetallicizePower(AbstractDungeon.player, this.counter), this.counter));
	}


	@Override
	public void betterOnSmith(AbstractCard arg0) {
		this.counter+=BLOCKPERSMITH;
		
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + this.counter + DESCRIPTIONS[1] + BLOCKPERSMITH + DESCRIPTIONS[2];
	}

}
