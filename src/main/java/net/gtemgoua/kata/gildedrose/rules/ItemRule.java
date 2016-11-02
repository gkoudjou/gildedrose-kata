package net.gtemgoua.kata.gildedrose.rules;

import net.gtemgoua.kata.gildedrose.domain.Item;

public abstract class ItemRule {
	private static final int MIN_BOUNDARY = 0;
	private static final int MAX_BOUNDARY = 50;

	public abstract void apply(Item item);
	
	protected void qualityBoundaryControl(Item item) {
		item.quality = item.quality > MAX_BOUNDARY ? MAX_BOUNDARY : item.quality;
		item.quality = item.quality < MIN_BOUNDARY ? MIN_BOUNDARY : item.quality;
	}
}
