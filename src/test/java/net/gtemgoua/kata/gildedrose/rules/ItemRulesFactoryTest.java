package net.gtemgoua.kata.gildedrose.rules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import net.gtemgoua.kata.gildedrose.Constants;
import net.gtemgoua.kata.gildedrose.domain.Item;

public class ItemRulesFactoryTest {
	
	private Item normalItem;
	private Item conjuredItem;
	private Item sulfurasItem;
	private Item backStageItem;
	private Item agedBrieItem;
	
	@Before
	public void setUp() {
		
		normalItem = new Item("WhatEverNameHereIsNorma", 5, 10);
		conjuredItem = new Item(Constants.CONJURED, 5, 10);
		sulfurasItem = new Item(Constants.SULFURAS_HAND_OF_RAGNAROS, 5, 10);
		backStageItem = new Item(Constants.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 5, 10);
		agedBrieItem = new Item(Constants.AGED_BRIE, 5, 10);
		
	}

	@Test
	public void thatNormalRuleInstanceIsCreateForNormalItem() {
		assertThat(ItemRulesFactory.createFor(normalItem)).isInstanceOf(NormalItemRule.class);
	}
	
	@Test
	public void thatConjuredRuleInstanceIsCreateForConjuredItem() {
		assertThat(ItemRulesFactory.createFor(conjuredItem)).isInstanceOf(ConjuredItemRule.class);
	}
	
	@Test
	public void thatSulfurasRuleInstanceIsCreateForSulfurasItem() {
		assertThat(ItemRulesFactory.createFor(sulfurasItem)).isInstanceOf(SulfurasItemRule.class);
	}
	
	@Test
	public void thatBackstageRuleInstanceIsCreateForBackStageItem() {
		assertThat(ItemRulesFactory.createFor(backStageItem)).isInstanceOf(BackStageItemRule.class);
	}
	
	@Test
	public void thatAgedBrieRuleInstanceIsCreateForAgedBrieItem() {
		assertThat(ItemRulesFactory.createFor(agedBrieItem)).isInstanceOf(AgedBrieItemRule.class);
	}
}
