package net.gtemgoua.kata.gildedrose.util;

import java.util.Random;

public class RandomIntegerGenerator {
	
	private static Random random = new Random();

	public static int randomInt(int max) {
		return random.nextInt(max);
	}
	
}
