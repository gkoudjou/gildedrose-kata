package net.gtemgoua.kata.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class GildedRoseTest {
	
	private GildedRose application;
	private Item[] items;
	private Item normalItem;
	
	@Before
	public void setUp() {
		
		normalItem = new Item("foo", 5, 10); 
		items = new Item[] {
				normalItem
		};
		
		application = new GildedRose(items);
	}

    @Test
    public void thatNormalItemQualityShouldNeverBeNegative() {
    	normalItem.quality = 0;
    	normalItem.sellIn = 1;
        
    	application.updateQuality();
        
    	assertThat(normalItem.quality).as("Quality of normal item").isEqualTo(0);
    }
    
    @Test
    public void thatWhenSellDateHasPassed_ShouldResultInQualityDecreasesTwiceAsFast() {
    	normalItem.quality = 4;
    	normalItem.sellIn = 0;
        
    	application.updateQuality();
        
    	assertThat(normalItem.quality).as("Quality of normal item when sell date has passed").isEqualTo(2);
    	assertThat(normalItem.sellIn).as("Quality of normal item when sell date has passed").isEqualTo(-1);
    }    

}
