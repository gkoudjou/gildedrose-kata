package net.gtemgoua.kata.gildedrose.rules;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class BackStageItemRule implements ItemRule {

	public void apply(Item item) {
		if(item.sellIn > 10)
			item.quality++;
		else {
			if(item.sellIn == 0)
				item.quality = 0;
			else if(item.sellIn <= 5)
				item.quality += 3;
			else if(item.sellIn > 5)
				item.quality += 2;
		}
    	
    	if( item.quality > 50)
    		item.quality = 50;
    	
    	item.sellIn--;
	}

}
