package helper;

import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class MonsterLogic {
	
	public static boolean monsterIntendsToAttack(AbstractMonster monster) {
		return (monster.intent == AbstractMonster.Intent.ATTACK) || (monster.intent == AbstractMonster.Intent.ATTACK_BUFF) || (monster.intent == AbstractMonster.Intent.ATTACK_DEBUFF) || (monster.intent == AbstractMonster.Intent.ATTACK_DEFEND);
	}
	
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
