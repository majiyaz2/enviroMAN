package com.mhlongo.enviro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mhlongo.enviro.model.Tip;



public class TipModelTest {
    private static final Logger log = LoggerFactory.getLogger(TipModelTest.class);
    
    private Tip getTestTip(){
        return new Tip(TestTip.ID, TestTip.TITLE, TestTip.CATEGORY, TestTip.CONTENT);
    }

     /**
     * Creates a test Tip and asserts that the Tip has the same values.
     */
    @Test
    public void testItem(){
        Tip tip = null;

        log.info("Testing Category class");
        tip = getTestTip();
        Assertions.assertThat(TestTip.ID).isEqualTo(tip.getID());
        Assertions.assertThat(TestTip.TITLE).isEqualTo(tip.getTitle());
        Assertions.assertThat(TestTip.CATEGORY).isEqualTo(tip.getCategory());
        Assertions.assertThat(TestTip.CONTENT).isEqualTo(tip.getContent());
        log.info("Done Testing Category class");
    }
}
