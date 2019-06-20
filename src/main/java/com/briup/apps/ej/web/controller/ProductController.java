package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.service.IProductService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("findAll")
    public Message findAll(){
        List<Product> list =productService.findAll();
        return MessageUtil.success("success",list);
    }

    @GetMapping("findProductById")
    @ApiOperation("通过ID查询产品信息")
    public Message findProductById(@ApiParam(value = "主键",required =true)@RequestParam("id") Long id){
        Product product=productService.findProductById(id);
        return MessageUtil.success("查询成功",product);
    }
    @PostMapping("insertOrUpdate")
    @ApiOperation("新增或者更新产品信息")
    public Message insertOrUpdate(Product product)throws Exception{
        try{
            productService.insertOrUpdate(product);
            return MessageUtil.success("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error("更新失败");
        }
    }
    @GetMapping("deleteProductById")
    @ApiOperation("根据ID删除产品信息")
    public Message deleteProductById(@ApiParam(value="主键",required=true)@RequestParam("id") Long id)throws Exception{
        try {
            productService.deleteProductById(id);
            return MessageUtil.success("success");
        }catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error("删除失败");
        }
    }
    @GetMapping("query")
    @ApiOperation("模糊查询产品信息")
    public Message query(String name){
        List<Product> list=productService.query(name);
        return MessageUtil.success("success",list);
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message BatchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception {
        try {
            productService.batchDelete(ids);
            return MessageUtil.success("批量删除成功");
        }catch (Exception e)
        {
            e.printStackTrace();
            return MessageUtil.error("删除失败");
        }
    }
}