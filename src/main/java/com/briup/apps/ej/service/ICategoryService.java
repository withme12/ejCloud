package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Category;

import java.util.List;

public interface ICategoryService {

    int saveOrUpdate(Category category);

    int deleteByPrimaryKey(Long id);

     List<Category> selectByName(String name);




}
