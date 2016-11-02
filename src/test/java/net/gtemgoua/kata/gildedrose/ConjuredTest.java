package net.gtemgoua.kata.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class ConjuredTest {

	private GildedRose application;
	private Item[] items;
	private Item conjured;
	
	@Before
	public void setUp() {
		conjured = new Item("Conjured", 5, 10); 
		items = new Item[] {
				conjured
		};
		
		application = new GildedRose(items);
	}
	
	@Test
	public void thatQuantityCanNotExceedFifty() {
		conjured.quality = 50;
		conjured.sellIn = 10;
		
		application.updateQuality();
		
		assertThat(conjured.quality).as("Quality").isEqualTo(48).as("The quality decreased twice as fast as normal item. So 50 - 2 = 48");
		assertThat(conjured.quality).as("SellIn").isEqualTo(9);
	}
	
	@Test
	public void thatQuantityCanNotBeNegative() {
		conjured.quality = 0;
		conjured.sellIn = 0;
		
		application.updateQuality();
		
		assertThat(conjured.quality).as("Quality").isEqualTo(0);
		assertThat(conjured.sellIn).as("SellIn").isEqualTo(-1);
	}
    
	@Test
	public void thatOneDayOldConjured_ShouldResultInQualityDecreasedBy_two_WhenSellDateHasNotPassed() {
		conjured.sellIn = 10;
		conjured.quality = 10;
		
		application.updateQuality();
		
		assertThat(conjured.quality).as("Quality of one day old Aged Brie").isEqualTo(8);
		assertThat(conjured.sellIn).as("SellIn of one day old Aged Brie").isEqualTo(9);
	}
	
	@Test
	public void thatOneDayOldConjured_ShouldResultInQualityDecreasedBy_four_WhenSellDateHasPassed() {
		conjured.sellIn = 10;
		conjured.quality = -1;
		
		application.updateQuality();
		
		assertThat(conjured.quality).as("Quality of one day old Aged Brie").isEqualTo(6);
		assertThat(conjured.sellIn).as("SellIn of one day old Aged Brie").isEqualTo(-2);
	}	
}
