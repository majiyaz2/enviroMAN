package com.enviro.assessment.grad001.andilemhlongo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enviro.assessment.grad001.andilemhlongo.model.TipModel;


public class TipModelTest {
    private static final Logger log = LoggerFactory.getLogger(TipModelTest.class);
    
    private TipModel getTestTip(){
        return new TipModel(TestTip.ID, TestTip.TITLE, TestTip.CATEGORY, TestTip.CONTENT);
    }

     /**
     * Creates a test Tip and asserts that the Tip has the same values.
     */
    @Test
    public void testItem(){
        TipModel tip = null;

        log.info("Testing Tip class");
        tip = getTestTip();
        Assertions.assertThat(TestTip.ID).isEqualTo(tip.getID());
        Assertions.assertThat(TestTip.TITLE).isEqualTo(tip.getTitle());
        Assertions.assertThat(TestTip.CATEGORY).isEqualTo(tip.getCategory());
        Assertions.assertThat(TestTip.CONTENT).isEqualTo(tip.getContent());
        log.info("Done Testing Tip class");
    }
}
