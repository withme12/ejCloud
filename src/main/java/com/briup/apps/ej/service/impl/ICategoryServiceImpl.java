package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.*;
import com.briup.apps.ej.bean.extend.CategoryExtend;
import com.briup.apps.ej.dao.CategoryMapper;

import com.briup.apps.ej.dao.extend.CategoryExtendMapper;
import com.briup.apps.ej.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ICategoryServiceImpl implements ICategoryService {
    @Resource
    CategoryMapper cm;
    @Resource
    private CategoryExtendMapper categoryExtendMapper;

//    @Override
//    public List<CategoryExtend> findProductWithCategory(Long id) {
//        return categoryExtendMapper.findProductWithCategory(id);
//    }

    @Override
    public int insertOrUpdate(Category category) {
        if(category.getId()==null)
            return cm.insert(category);

          return  cm.updateByPrimaryKeySelective(category);

    }

    @Override
    public List<CategoryExtend> findAllProductWithCategory(Long id) {
        return categoryExtendMapper.findAllProductWithCategory(id);
    }

    @Override
    public List<Category> findAll() {
        CategoryExample ce=new CategoryExample();
        return cm.selectByExample(ce);
    }

    @Override
    public List<Category> query(Category category) {
        CategoryExample ce=new CategoryExample();
        if(category.getName()!=null)
            ce.createCriteria().andNameLike("%"+category.getName()+"%");

        return cm.selectByExample(ce);
    }

    public int deleteByPrimaryKeys(Long[] ids) {
        for (Long id:ids) {
            cm.deleteByPrimaryKey(id);
        }
        return 1;
    }
    @Override
    public int deleteByPrimaryKey(Long id) {
        return cm.deleteByPrimaryKey(id);
    }



    @Override
    public Category selectByPrimaryKey(Long id) {
        return cm.selectByPrimaryKey(id);
    }



}
