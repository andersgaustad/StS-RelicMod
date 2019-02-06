package relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class MidnightOil extends AbstractRelicModRelic {

	public static final String ID ="Midnight_Oil";
	
	private static final int MIDNIGHTTURN = 12;
	
	private static final int STRENGTHINCREASE = 6;
	private static final int DEXTERITYINCREASE = 6;
	
	public MidnightOil() {
		super(ID, RelicTier.RARE, LandingSound.CLINK); 
	}
	
	
	@Override
	public void atBattleStart() {
		this.counter = 0;
	}
	
	@Override
	public void atTurnStart() {
		this.counter++;
		
		if (this.counter % MIDNIGHTTURN == 0 ) {
			// Relic activates!
			this.flash();
			AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			this.counter = 0;
			
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, STRENGTHINCREASE)));
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DexterityPower(AbstractDungeon.player, DEXTERITYINCREASE)));
			
		}
	}
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + String.valueOf(MIDNIGHTTURN) + DESCRIPTIONS[1] + String.valueOf(STRENGTHINCREASE) + DESCRIPTIONS[2] + String.valueOf(DEXTERITYINCREASE) + DESCRIPTIONS[3];
	}
	
}
