package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.Product;

public class CategoryExtend extends Product {
  private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
