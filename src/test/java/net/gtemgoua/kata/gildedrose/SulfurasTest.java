package net.gtemgoua.kata.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import net.gtemgoua.kata.gildedrose.domain.Item;
import net.gtemgoua.kata.gildedrose.util.RandomIntegerGenerator;

public class SulfurasTest {

	private GildedRose application;
	private Item[] items;
	private Item sulfuras;
	
	@Before
	public void setUp() {
		
		//TODO : The original updateQuality doesn't force the sulfuras quality to 80 as expected !
		sulfuras = new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS, 5, 10); 
		items = new Item[] {
				sulfuras
		};
		
		application = new GildedRose(items);
	}
	
	@Test
	public void thatXDaysOldSulfuras_ShouldResultInQualityAndSellInUnchanged() {
		int x = RandomIntegerGenerator.randomInt(sulfuras.sellIn);
		
		for(int i = 0; i < x; i++)
			application.updateQuality();
		
		assertThat(sulfuras.quality).as("Quality of x days old Sulfuras").isEqualTo(10);
		assertThat(sulfuras.sellIn).as("SellIn of x days old Sulfuras").isEqualTo(5);
	}
	
	@Test
	public void thatWhenSellDateHasPassed_SulfurasItemAttributeStillUnchanged() {
		sulfuras.sellIn = -5;
		
		application.updateQuality();
		
		assertThat(sulfuras.quality).as("Quality").isEqualTo(10);
		assertThat(sulfuras.sellIn).as("SellIn").isEqualTo(-5);
	}
	
	@Test
	public void thatQuantityCanNotExceedFifty() {
		sulfuras.quality = 50;
		
		application.updateQuality();
		
		assertThat(sulfuras.quality).as("Quality").isEqualTo(50);
	}
	
	@Test
	public void thatQuantityCanNotBeNegative() {
		sulfuras.quality = 0;
		sulfuras.sellIn = 0;
		
		application.updateQuality();
		
		assertThat(sulfuras.quality).as("Quality").isEqualTo(0);
		assertThat(sulfuras.sellIn).as("SellIn").isEqualTo(0);
	}	
	
}
