package net.gtemgoua.kata.gildedrose.rules;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class NormalItemRule extends ItemRule {

	public void apply(Item item) {
    	if(item.sellIn <= 0)
    		item.quality -= 2;
    	else
    		item.quality--;
    	
    	this.qualityBoundaryControl(item);
    	item.sellIn--;
	}

}
