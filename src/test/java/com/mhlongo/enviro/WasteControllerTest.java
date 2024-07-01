package com.mhlongo.enviro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mhlongo.enviro.models.Category;

public class WasteControllerTest {
    private static final Logger log = LoggerFactory.getLogger(WasteControllerTest.class);
    private Category getTestCategory(){
        return new Category(TestCategory.ID, TestCategory.Name, TestCategory.DESCRIPTION, TestCategory.ISRECYCLABLE);

    }

     /**
     * Creates a test Category and asserts that the Category has the same values.
     */
    @Test
    public void testCategory(){
        Category category = null;

        log.info("Testing Category class");
        category = getTestCategory();
        Assertions.assertThat(TestCategory.ID).isEqualTo(category.getID());
        Assertions.assertThat(TestCategory.Name).isEqualTo(category.getName());
        Assertions.assertThat(TestCategory.ISRECYCLABLE).isEqualTo(category.getIsRecyclable());
        Assertions.assertThat(TestCategory.DESCRIPTION).isEqualTo(category.getDescription());
        log.info("Done Testing Category class");
    }
}
