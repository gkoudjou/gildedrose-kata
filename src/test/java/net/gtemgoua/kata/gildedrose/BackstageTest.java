package net.gtemgoua.kata.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class BackstageTest {

	private GildedRose application;
	private Item[] items;
	private Item backstage;
	
	@Before
	public void setUp() {
		backstage = new Item(Constants.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 5, 10); 
		items = new Item[] {
				backstage
		};
		
		application = new GildedRose(items);
	}
	
	@Test
	public void thatOneDayOldBackstage_ShouldResultInQualityIncreasedBy_One_WhenSellInIsBiggerThan_Ten() {
		backstage.sellIn = 15;
		
		application.updateQuality();
		
		assertThat(backstage.quality).as("Quality of one days old backstage with SellIn bigger than 10").isEqualTo(11);
		assertThat(backstage.sellIn).as("SellIn of one days old backstage with SellIn bigger than 10").isEqualTo(14);
	}
	
	@Test
	public void thatOneDayOldBackstage_ShouldResultInQualityIncreasedBy_Two_WhenSellInIsEqualTo_Ten() {
		backstage.sellIn = 10;
		
		application.updateQuality();
		
		assertThat(backstage.quality).as("Quality of one days old backstage with SellIn equal to 10").isEqualTo(12);
		assertThat(backstage.sellIn).as("SellIn of one days old backstage with SellIn equal to 10").isEqualTo(9);
	}
	
	@Test
	public void thatOneDayOldBackstage_ShouldResultInQualityIncreasedBy_Two_WhenSellInIsSmallerThan_Ten() {
		backstage.sellIn = 9;
		
		application.updateQuality();
		
		assertThat(backstage.quality).as("Quality of one days old backstage with SellIn smaller than 10").isEqualTo(12);
		assertThat(backstage.sellIn).as("SellIn of one days old backstage with SellIn smaller than 10").isEqualTo(8);
	}
	
	@Test
	public void thatOneDayOldBackstage_ShouldResultInQualityIncreasedBy_Three_WhenSellInIsEqualTo_Five() {
		backstage.sellIn = 5;
		
		application.updateQuality();
		
		assertThat(backstage.quality).as("Quality of one days old backstage with SellIn equal to 5").isEqualTo(13);
		assertThat(backstage.sellIn).as("SellIn of one days old backstage with SellIn equal to 5").isEqualTo(4);
	}
	
	@Test
	public void thatOneDayOldBackstage_ShouldResultInQualityIncreasedBy_Three_WhenSellInIsSmallerThan_Five() {
		backstage.sellIn = 3;
		
		application.updateQuality();
		
		assertThat(backstage.quality).as("Quality of one days old backstage with SellIn smaller than 5").isEqualTo(13);
		assertThat(backstage.sellIn).as("SellIn of one days old backstage with SellIn smaller than 5").isEqualTo(2);
	}
	
	@Test
	public void thatWhenSellDateHasPassed_ShouldResultIn_QualityDropTo_Zero() {
		backstage.sellIn = 0;
		
		application.updateQuality();
		
		assertThat(backstage.quality).as("Quality when sell date has passed").isEqualTo(0);
		assertThat(backstage.sellIn).as("SellIn when sell date has passed").isEqualTo(-1);
	}
	
	@Test
	public void thatQuantityCanNotExceedFifty() {
		backstage.quality = 50;
		backstage.sellIn = 10;
		
		application.updateQuality();
		
		assertThat(backstage.quality).as("Quality").isEqualTo(50);
	}
	
	@Test
	public void thatQuantityCanNotBeNegative() {
		backstage.quality = 2;
		backstage.sellIn = 0;
		
		application.updateQuality();
		
		assertThat(backstage.quality).as("Quality").isEqualTo(0).as("We will normally obtain -1 (2 - 3) here but due to the rule, we expected 0 as result");
		assertThat(backstage.sellIn).as("SellIn").isEqualTo(-1);
	}	

}
