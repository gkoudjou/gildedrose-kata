package net.gtemgoua.kata.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import net.gtemgoua.kata.gildedrose.domain.Item;
import net.gtemgoua.kata.gildedrose.util.RandomIntegerGenerator;

public class AgedBrieTest {
	
	private GildedRose application;
	private Item[] items;
	private Item agedBrie;
	
	@Before
	public void setUp() {
		
		agedBrie = new Item(GildedRose.AGED_BRIE, 5, 10); 
		items = new Item[] {
				agedBrie
		};
		
		application = new GildedRose(items);
	}
	
	@Test
	public void thatOneDayOldBrie_ShouldResultInQualityIncreasedAndSellingDecrementsBy_One() {

		application.updateQuality();
		
		assertThat(agedBrie.quality).as("Quality of one day old Aged Brie").isEqualTo(11);
		assertThat(agedBrie.sellIn).as("SellIn of one day old Aged Brie").isEqualTo(4);
	}
	
	@Test
	public void thatTwoDaysOldBrie_ShouldResultInQualityIncreasedAndSellingDecrementsBy_two() {

		application.updateQuality();
		application.updateQuality();
		
		assertThat(agedBrie.quality).as("Quality of two days old Aged Brie").isEqualTo(12);
		assertThat(agedBrie.sellIn).as("SellIn of two days old Aged Brie").isEqualTo(3);
	}
	
	@Test
	public void thatXDaysOldBrie_ShouldResultInQualityIncreasedAndSellingDecrementsBy_X() {

		int x = RandomIntegerGenerator.randomInt(agedBrie.sellIn);
		int initialSellInValue = agedBrie.sellIn;
		int initialQualityValue = agedBrie.quality;
		
		for(int i = 0; i < x; i++)
			application.updateQuality();
		
		assertThat(agedBrie.quality).as("Quality of one day Old Aged Brie").isEqualTo(initialQualityValue + x);
		assertThat(agedBrie.sellIn).as("SellIn of one day Old Aged Brie").isEqualTo(initialSellInValue - x);
	}
	
	@Test
	public void thatWhenSellDateHasPassed_ShouldResultInQualityIncreasesTwiceAsFast() {
		
		agedBrie.sellIn = -1;
		
		application.updateQuality();
		
		assertThat(agedBrie.quality).as("Quality of one days old Aged Brie when Sell date has passed").isEqualTo(12);
		assertThat(agedBrie.sellIn).as("SellIn").isEqualTo(-2);
	}

}
