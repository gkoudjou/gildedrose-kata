package net.gtemgoua.kata.gildedrose;

import net.gtemgoua.kata.gildedrose.domain.Item;

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
    		if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
        		applySulfurasRules(item);
        	}
        	else if (item.name.equals(AGED_BRIE)) {
        		applyAgedBrieRules(item);
        	}
        	else if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
        		applyBackStagesRules(item);
        	}
        	else if (item.name.equals(CONJURED)) {
        		applyConjuredRules(item);
        	}
        	else
        		applyNormalRules(item);
		}
    }
    
    private void applyConjuredRules(Item item) {
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

	private void applyNormalRules(Item item) {
    	if(item.sellIn <= 0)
    		item.quality -= 2;
    	else
    		item.quality--;
    	
    	if( item.quality > 50)
    		item.quality = 50;
    	
    	if(item.quality < 0)
    		item.quality = 0;
    	
    	item.sellIn--;
	}

	private void applyBackStagesRules(Item item) {
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

	private void applyAgedBrieRules(Item item) {
    	if(item.sellIn <= 0)
    		item.quality += 2;
    	else
    		item.quality++;
    	
    	if( item.quality > 50)
    		item.quality = 50;
    	
    	item.sellIn--;
	}

	private void applySulfurasRules(Item item) {
		//NOTHING TODO. item is unchanged
	}
}
