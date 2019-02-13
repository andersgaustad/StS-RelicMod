package old;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.actions.AbstractGameAction;

import relicmod.RelicMod;
import relics.AbstractRelicModRelic;

public class OldTrebuchetToy extends AbstractRelicModRelic {

	public static final Logger logger = LogManager.getLogger(RelicMod.class.getName());
	
	public static final String ID = "Trebuchet_Toy";
	
	private static final int POTIONTHROWNEXTRADAMAGE = 10;
	
	
	private HashMap<AbstractPotion, Integer> preUsePotionsMap;
	
	
	public OldTrebuchetToy() {
		super(ID, RelicTier.SHOP, LandingSound.FLAT);
		 //this.preUsePotionsMap = createPotionCount(AbstractDungeon.player.potions);
	}
	
	
	@Override
	public void atTurnStart() {
		this.preUsePotionsMap = createPotionCount(AbstractDungeon.player.potions);
	}
	
	@Override
	public void onUsePotion() {
		AbstractPotion lastUsedPotion = null;
		
		HashMap<AbstractPotion, Integer> potionsRightNow = createPotionCount(AbstractDungeon.player.potions);
		
		boolean potionFound = false;
		for (AbstractPotion potion : preUsePotionsMap.keySet()) {
			if (!potionsRightNow.containsKey(potion)) {
				potionFound = true;
				
			} else if (potionsRightNow.get(potion) < preUsePotionsMap.get(potion)) {
				potionFound = true;
			}
			
			if (potionFound) {
				lastUsedPotion = potion;
				break;
			}
			
		}
		
		logger.info("Potion found!");
		if (lastUsedPotion!=null) {
			logger.info("Potion is " + lastUsedPotion.ID);
			if (lastUsedPotion.isThrown) {
				// Relic finally activates
				this.flash();
				AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
				
				AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(null, DamageInfo.createDamageMatrix(POTIONTHROWNEXTRADAMAGE, true), DamageType.NORMAL, AbstractGameAction.AttackEffect.SMASH));
			}
			
		} else {
			logger.info("Warning: Could not find last potion used?");
		}
		
		this.preUsePotionsMap = createPotionCount(AbstractDungeon.player.potions);
	}
	
	
	@Override
	public String getUpdatedDescription() {
		return DESCRIPTIONS[0] + POTIONTHROWNEXTRADAMAGE + DESCRIPTIONS[1];
	}
	
	
	private static HashMap<AbstractPotion, Integer> createPotionCount(List<AbstractPotion> list) {
		HashMap<AbstractPotion, Integer> map = new HashMap<AbstractPotion, Integer>();
		
		for (AbstractPotion potion : list) {
			if (map.containsKey(potion)) {
				map.put(potion, map.get(potion) + 1);
				
			} else {
				map.put(potion, 1);
			}
		}
		
		return map;
	}
	
}
