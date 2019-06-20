package com.briup.apps.ej.service;


import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.extend.CategoryExtend;

import java.util.List;


public interface ICategoryService {
    int deleteByPrimaryKey(Long id);

    Category selectByPrimaryKey(Long id);
    int deleteByPrimaryKeys(Long[] ids);
    int insertOrUpdate(Category category);
    List<Category> findAll();
    List<Category> query(Category category);
//    List<CategoryExtend> findProductWithCategory(Long id);
List<CategoryExtend> findAllProductWithCategory(Long id);


}
