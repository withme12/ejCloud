package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.CategoryExample;
import com.briup.apps.ej.dao.CategoryMapper;
import com.briup.apps.ej.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ICategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public int saveOrUpdate(Category category) {
        if (category.getId() == null) {
            return categoryMapper.insert(category);
        } else {
            return categoryMapper.updateByPrimaryKey(category);
        }
    }

    @Override
    public List<Category> selectByName(String name) {
        List<Category> list = categoryMapper.selectByName(name);
        return list;
    }

    @Override
    public int deleteByPrimaryKey(Long id) throws Exception {
        Category category = categoryMapper.selectByPrimaryKey(id);

        if (category == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            return categoryMapper.deleteByPrimaryKey(id);
        }
    }
}