package net.gtemgoua.kata.gildedrose;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class GildedRoseTest {

    @Test
    public void thatNormalItemQualityShouldNeverBeNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals("foo", app.items[0].name);
        assertTrue(app.items[0].quality >= 0);
    }

}
