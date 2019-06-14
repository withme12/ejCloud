package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.service.IProductService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.MessageUtils;

import java.util.List;

@Api(description = "产品管理接口")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ApiOperation("查询所有产品信息")
    @GetMapping("findAll")
    public Message findAll(){
        List<Product> list=productService.findAll();
        return MessageUtil.success("查询所有产品信息成功！",list);
    }

    @ApiOperation("保存或更新产品信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Product product) throws Exception{
        productService.saveOrUpdate(product);
        return MessageUtil.success("保存或更新产品信息成功");
    }
    @ApiOperation("通过ID删除产品信息")
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        try{
            productService.deleteById(id);
            return MessageUtil.success("删除产品成功");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("通过ID查找产品信息")
    @GetMapping("selectById")
    public Message selectById(Long id){
        if(id==null)
            return MessageUtil.error("该产品不存在");
        else{
            Product product = productService.selectById(id);
            return MessageUtil.success("查找产品成功",product);
        }
    }

}
