package net.gtemgoua.kata.gildedrose.rules;

import net.gtemgoua.kata.gildedrose.Constants;
import net.gtemgoua.kata.gildedrose.GildedRose;
import net.gtemgoua.kata.gildedrose.domain.Item;

public class ItemRulesFactory {
	
	private static NormalItemRule normalItemRule = new NormalItemRule();
	private static ConjuredItemRule conjuredItemRule = new ConjuredItemRule();
	private static SulfurasItemRule sulfurasItemRule = new SulfurasItemRule();
	private static BackStageItemRule backstageItemRule = new BackStageItemRule();
	private static AgedBrieItemRule agedBrieItemRule = new AgedBrieItemRule();

	public static ItemRule createFor(Item item) {
		ItemRule rule;
		
		if (item.name.equals(Constants.SULFURAS_HAND_OF_RAGNAROS)) {
    		rule = sulfurasItemRule;
    	}
    	else if (item.name.equals(Constants.AGED_BRIE)) {
    		rule = agedBrieItemRule;
    	}
    	else if (item.name.equals(Constants.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
    		rule = backstageItemRule;
    	}
    	else if (item.name.equals(Constants.CONJURED)) {
    		rule = conjuredItemRule;
    	}
    	else
    		rule = normalItemRule;
		
		return rule;
	}
	
	public static void updateQualityFor(Item item) {
		createFor(item).apply(item);
	}
}
