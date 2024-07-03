package com.enviro.assessment.grad001.andilemhlongo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enviro.assessment.grad001.andilemhlongo.model.CategoryModel;



public class CategoryModelTest {
    private static final Logger log = LoggerFactory.getLogger(CategoryModel.class);
    private CategoryModel getTestCategory(){
        return new CategoryModel(TestCategory.ID, TestCategory.Name, TestCategory.DESCRIPTION, TestCategory.ISRECYCLABLE);

    }

     /**
     * Creates a test Category and asserts that the Category has the same values.
     */
    @Test
    public void testCategory(){
        CategoryModel category = null;

        log.info("Testing Category class");
        category = getTestCategory();
        Assertions.assertThat(TestCategory.ID).isEqualTo(category.getId());
        Assertions.assertThat(TestCategory.Name).isEqualTo(category.getName());
        Assertions.assertThat(TestCategory.ISRECYCLABLE).isEqualTo(category.getIsRecyclable());
        Assertions.assertThat(TestCategory.DESCRIPTION).isEqualTo(category.getDescription());
        log.info("Done Testing Category class");
    }
}
