package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.service.ICategoryService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("deleteById")
    public Message deleteById(Long id) throws Exception {
        try {
            categoryService.deleteByPrimaryKey(id);
            return MessageUtil.success("删除成功");
        } catch (Exception e) {
            return MessageUtil.error(e.getMessage());
        }
    }

    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Category category){
        try{
            categoryService.saveOrUpdate(category);
            return MessageUtil.success("成功");
        }catch (Exception e){
            return MessageUtil.error(e.getMessage());
        }
    }
    @GetMapping("selectByName")
    public Message selectByName(String name){
        List<Category> list= categoryService.selectByName(name);
        return MessageUtil.success("成功",list);
    }
}
