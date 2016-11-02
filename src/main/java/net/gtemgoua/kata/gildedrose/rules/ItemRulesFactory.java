package net.gtemgoua.kata.gildedrose.rules;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class ItemRulesFactory {
	
	private static NormalItemRule normalItemRule = new NormalItemRule();

	public static ItemRule createFor(Item item) {
		return normalItemRule;
	}
}
