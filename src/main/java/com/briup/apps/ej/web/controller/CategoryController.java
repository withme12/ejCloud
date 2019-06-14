package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.service.ICategoryService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "分类管理接口")
@RestController
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("查找所有类别")
    @GetMapping("findAll")
    public Message findAll(){
        List<Category> list = categoryService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id删除产品类别")
    @GetMapping("deleteById")
    public Message deleteById(Long id) throws Exception {
        try {
            categoryService.deleteByPrimaryKey(id);
            return MessageUtil.success("删除成功");
        } catch (Exception e) {
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("保存或更新产品类别")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Category category){
        try{
            categoryService.saveOrUpdate(category);
            return MessageUtil.success("成功");
        }catch (Exception e){
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("通过产品类别名查询")
    @GetMapping("selectByName")
    public Message selectByName(String name){
        List<Category> list= categoryService.selectByName(name);
        return MessageUtil.success("成功",list);
    }
}
