package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.extend.OrderLineExtend;
import com.briup.apps.ej.service.IOrder_lineService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_line")
public class Order_lineController {

    @Autowired
    private IOrder_lineService order_lineService;

    @GetMapping("findAll")
    public Message findAll(){
        List<OrderLine> list = order_lineService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        return MessageUtil.success("success",order_lineService.findOrder_lineById(id));
    }

    @ApiOperation("通过id删除用户")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        try {
            order_lineService.deleteOrder_lineById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("批量删除")
    @PostMapping("batchDelete")
    public Message batchDelete(long[] ids) throws Exception{
        order_lineService.batchDelete(ids);
        return MessageUtil.success("9批量删除成功");
    }

    @ApiOperation("保存或更新用户信息")
    @PostMapping("saveOrUpdate")
    public Message insertOrUpdate(OrderLine order_line) {
        try {
            order_lineService.insertOrUpdate(order_line);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("根据order的ID查询订单详细信息")
    @GetMapping("findOrderDetails")
    public Message findOrderDetails( @ApiParam(value = "主键",required = true)
                                         @RequestParam(value = "id")Long id) {

           List<OrderLineExtend> list=order_lineService.findOrderDetails(id);
    return MessageUtil.success("success",list);
    }
    }


