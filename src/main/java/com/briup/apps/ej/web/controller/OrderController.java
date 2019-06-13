package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.service.IOrderService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;


    @ApiOperation("查询所有订单")
    @GetMapping("findAll")
    public Message findAll(){
        List<Order> list = orderService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("保存或更新订单信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Order order) throws Exception{
        orderService.saveOrUpdate(order);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation("通过ID删除订单信息")
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        try{
            orderService.deleteById(id);
            return MessageUtil.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("通过ID查找订单信息")
    @GetMapping("selectById")
    public Message selectById(Long id){
        if(id==null)
            return MessageUtil.error("用户不存在");
        else{
            Order order = orderService.selectById(id);
            return MessageUtil.success("查找成功",order);
        }
    }
}
