package net.gtemgoua.kata.gildedrose.rules;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class ConjuredItemRule implements ItemRule {

	public void apply(Item item) {
    	if(item.sellIn <= 0)
    		item.quality -= 4;
    	else
    		item.quality -= 2;
    	
    	if( item.quality > 50)
    		item.quality = 50;
    	
    	if(item.quality < 0)
    		item.quality = 0;
    	
    	item.sellIn--;
	}

}
