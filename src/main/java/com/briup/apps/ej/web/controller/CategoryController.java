package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.extend.CategoryExtend;
import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.service.ICategoryService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
@Api(description = "种类管理相关接口")
@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {



        @Autowired
        ICategoryService ics;

        @ApiOperation("查找通过id")
        @GetMapping("/selectByPrimaryKey")
        public Message selectByPrimaryKey(@ApiParam(value = "主键", required = true)
                                          @RequestParam(value = "id") Long id) {
            return MessageUtil.success("success", ics.selectByPrimaryKey(id));
        }

        @ApiOperation("删除通过id")
        @GetMapping("/deleteById")
        public Message deleteByPrimaryKey(
                @NotNull
                @ApiParam(value = "主键", required = true)
                                          @RequestParam(value = "id") Long id) {
            return MessageUtil.success("success", ics.deleteByPrimaryKey(id));
        }

    @ApiOperation("删除通过ids")
    @PostMapping("/batchDelete")
    public Message deleteByPrimaryKeys(@ApiParam(value ="主键" ,required=true)
                                       @RequestParam(value="ids") Long[] ids){
        return MessageUtil.success("success",ics.deleteByPrimaryKeys(ids));
    }

        @ApiOperation("插入")
        @PostMapping("/insertOrUpdate")
        public Message insertOrUpdate(Category category) {
            return MessageUtil.success("success", ics.insertOrUpdate(category));
        }
    @ApiOperation("查找所有")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", ics.findAll());
    }

//    @ApiOperation("查看分类下产品信息")
//    @GetMapping("/findProductWithCategory")
//    public Message findAllWithCategory(Long id) {
//        return MessageUtil.success("success", ics.findProductWithCategory(id));
//    }

    @GetMapping("query")
    @ApiOperation("模糊查询种类信息")
    public Message query(Category category){
        List<Category> list=ics.query(category);
        return MessageUtil.success("success",list);
    }
    @GetMapping("findAllProductWithCategory")
    @ApiOperation("通过id查询该种类下所有产品")
    public Message findAllProductWithCategory(@ApiParam(value ="主键" ,required=true)@NotNull@RequestParam(value ="id") Long id){
        List<CategoryExtend> list=ics.findAllProductWithCategory(id);
        return MessageUtil.success("success",list);
    }




}

