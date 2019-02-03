package helper;

import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Helper {

	public static boolean enemyIsElite(AbstractMonster monster) {
		return enemyIsType(monster, AbstractMonster.EnemyType.ELITE);
	}
	
	public static boolean enemyIsBoss(AbstractMonster monster) {
		return enemyIsType(monster, AbstractMonster.EnemyType.BOSS);
	}
	
	public static boolean enemyIsType(AbstractMonster monster, AbstractMonster.EnemyType enemyType) {
		return (monster.type == enemyType);
	}
	
}
