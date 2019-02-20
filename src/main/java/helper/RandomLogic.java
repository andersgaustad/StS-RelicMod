package helper;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLogic {
	
	public static boolean roll(int percentChance) {
		return roll(0, 100, percentChance);
	}
	
	public static boolean roll(int lower, int upper, int limit) {
		int randomNumber = getRandomNumber(lower, upper);
		
		return (randomNumber < limit);
	}
	
	public static int getRandomNumber(int lower, int upper) {
		return ThreadLocalRandom.current().nextInt(lower, upper);
	}

}
