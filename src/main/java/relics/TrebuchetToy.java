package relics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.evacipated.cardcrawl.mod.stslib.relics.BetterOnUsePotionRelic;
import com.megacrit.cardcrawl.actions.AbstractGameAction;

import relicmod.RelicMod;
import relics.AbstractRelicModRelic;

public class TrebuchetToy extends AbstractRelicModRelic implements BetterOnUsePotionRelic {

	public static final Logger logger = LogManager.getLogger(RelicMod.class.getName());
	
	public static final String ID = "Trebuchet_Toy";
	
	private static final int POTIONTHROWNEXTRADAMAGE = 10;
	
	
	public TrebuchetToy() {
		super(ID, RelicTier.SHOP, LandingSound.HEAVY);
		
	}
	
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + POTIONTHROWNEXTRADAMAGE + DESCRIPTIONS[1];
	}



	@Override
	public void betterOnUsePotion(AbstractPotion arg0) {
		if (arg0.isThrown) {
			this.flash();
			AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
			
			AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(null, DamageInfo.createDamageMatrix(POTIONTHROWNEXTRADAMAGE, true), DamageType.NORMAL, AbstractGameAction.AttackEffect.SMASH));
			
		}
		
		
	}
	
}