package net.gtemgoua.kata.gildedrose;

import net.gtemgoua.kata.gildedrose.domain.Item;

class GildedRose {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final String AGED_BRIE = "Aged Brie";

	Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	if (items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
        		applySulfurasRules(items[i]);
        	}
        	else if (items[i].name.equals(AGED_BRIE)) {
        		applyAgedBrieRules(items[i]);
        	}
        	else if (items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
        		applyBackStagesRules(items[i]);
        	}
        	else
        		old_updateQuality(items[i]);
        
        }
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

	public void old_updateQuality(Item item) {
            if (!item.name.equals(AGED_BRIE)
                    && !item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
}
