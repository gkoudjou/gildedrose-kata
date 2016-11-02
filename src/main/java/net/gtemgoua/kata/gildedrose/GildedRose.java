package net.gtemgoua.kata.gildedrose;

import net.gtemgoua.kata.gildedrose.domain.Item;
import net.gtemgoua.kata.gildedrose.rules.ItemRulesFactory;

public class GildedRose {
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
