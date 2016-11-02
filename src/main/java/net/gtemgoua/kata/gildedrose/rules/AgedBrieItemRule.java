package net.gtemgoua.kata.gildedrose.rules;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class AgedBrieItemRule implements ItemRule {

	public void apply(Item item) {
    	if(item.sellIn <= 0)
    		item.quality += 2;
    	else
    		item.quality++;
    	
    	if( item.quality > 50)
    		item.quality = 50;
    	
    	item.sellIn--;
	}

}
