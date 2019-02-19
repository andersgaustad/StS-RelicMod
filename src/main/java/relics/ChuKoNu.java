package relics;

import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.actions.AbstractGameAction;

public class ChuKoNu extends AbstractRelicModRelic {

	public static final String ID ="Chu_Ko_Nu";
	
	private static final int DAMAGEPERSHOT = 5;
	private static final int SHOTS = 2;
	
	private boolean noCardTarget = true;
	
	public ChuKoNu() {
		super(ID, RelicTier.UNCOMMON, LandingSound.SOLID);
	}
	
	
	@Override
	public void atBattleStart() {
		this.noCardTarget = true;
		this.beginLongPulse();
		
	}
	
	@Override
	public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
		AbstractCreature targetCreature = useCardAction.target;
		if (targetCreature!=null) {
			if (targetCreature instanceof AbstractMonster) {
				this.noCardTarget = false;
				this.stopPulse();
			}
		}
	}
	
	@Override
	public void onPlayerEndTurn() {
		if (this.noCardTarget) {
			// Relic activates!
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			for (int i=0; i<SHOTS; i++) {
				AbstractDungeon.actionManager.addToBottom(new DamageRandomEnemyAction(new DamageInfo(AbstractDungeon.player, DAMAGEPERSHOT, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
			}
			
			this.stopPulse();
		}
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + DAMAGEPERSHOT + DESCRIPTIONS[1] + SHOTS + DESCRIPTIONS[2]; 
	}
}
