package net.gtemgoua.kata.gildedrose;

import net.gtemgoua.kata.gildedrose.domain.Item;
import net.gtemgoua.kata.gildedrose.rules.ItemRulesFactory;

public class GildedRose {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final String AGED_BRIE = "Aged Brie";
	public static final String CONJURED = "Conjured Mana Cake";

	Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
    	for (Item item : items) {
    		ItemRulesFactory.createFor(item).apply(item);
		}
    }
}
