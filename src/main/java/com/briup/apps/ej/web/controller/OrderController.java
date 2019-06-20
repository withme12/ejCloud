package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.VM.OrderVM;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.service.IOrderService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("findAll")
    public Message findAll(){
        List<Order> list = orderService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findOrderById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        Order order =orderService.findOrderById(id);
        return MessageUtil.success("success",order);
    }

    @ApiOperation("通过id删除用户")
    @GetMapping("deleteById")
    public Message deleteOrderById(long id){
        try {
            orderService.deleteOrderById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("批量删除")
    @PostMapping("batchDelect")
    public Message batchDelect(long[] ids) throws Exception{
        orderService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }

    @ApiOperation("保存或更新用户信息")
    @PostMapping("saveOrUpdate")
    public Message insertOrUpdate(Order order) {
        try {
            orderService.insertOrUpdate(order);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }


    @ApiOperation("查询客户或者服务者全部订单信息")
    @PostMapping("queryBasic")
    public Message queryBasic(Long customerId, Long waiterId) {
        if (customerId==null&&waiterId==null){
            return MessageUtil.error("客户ID与顾客ID不能同时为空！");
        } else {
            List<OrderVM> list = orderService.queryBasic(customerId, waiterId);
            return MessageUtil.success("success", list);
        }
    }
}
