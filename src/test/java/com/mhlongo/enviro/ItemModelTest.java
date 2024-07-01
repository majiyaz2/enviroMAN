package com.mhlongo.enviro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mhlongo.enviro.model.Item;



public class ItemModelTest {
    private static final Logger log = LoggerFactory.getLogger(ItemModelTest.class);
    
    private Item getTestItem(){
        return new Item(TestItem.ID, TestItem.NAME, TestItem.DESCRIPTION, TestItem.WEIGHT, TestItem.DISPOSAL);

    }

     /**
     * Creates a test Item and asserts that the Item has the same values.
     */
    @Test
    public void testItem(){
        Item item = null;

        log.info("Testing Category class");
        item = getTestItem();
        Assertions.assertThat(TestItem.ID).isEqualTo(item.getID());
        Assertions.assertThat(TestItem.NAME).isEqualTo(item.getName());
        Assertions.assertThat(TestItem.DESCRIPTION).isEqualTo(item.getDescription());
        Assertions.assertThat(TestItem.WEIGHT).isEqualTo(item.getWeight());
        Assertions.assertThat(TestItem.DISPOSAL).isEqualTo(item.getDisposal());
        log.info("Done Testing Category class");
    }
}
