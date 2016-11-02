package net.gtemgoua.kata.gildedrose.rules;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class ConjuredItemRule extends ItemRule {

	public void apply(Item item) {
    	if(item.sellIn <= 0)
    		item.quality -= 4;
    	else
    		item.quality -= 2;
    	
    	this.qualityBoundaryControl(item);
    	item.sellIn--;
	}

}
