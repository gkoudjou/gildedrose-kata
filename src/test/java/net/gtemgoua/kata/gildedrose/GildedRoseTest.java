package net.gtemgoua.kata.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.gtemgoua.kata.gildedrose.domain.Item;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
