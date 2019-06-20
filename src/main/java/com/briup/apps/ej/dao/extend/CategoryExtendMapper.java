package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.extend.CategoryExtend;

import java.util.List;

public interface CategoryExtendMapper {
   List<CategoryExtend> findAllProductWithCategory(Long id);
}
