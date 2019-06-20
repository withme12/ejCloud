package com.briup.apps.ej.web.controller;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.service.ICustomerService;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
@Api(description = "顾客管理相关接口")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("findAll")
    public Message findAll(){
    List<Customer> list =customerService.findAll();
    return MessageUtil.success("success",list);
}
    @GetMapping("findCustomerById")
    @ApiOperation("通过ID查询顾客信息")
    public Message findCustomerById(@ApiParam(value = "主键",required =true)@RequestParam("id") Long id){
        Customer customer=customerService.findCustomerById(id);
        return MessageUtil.success("success",customer);
    }
    @PostMapping("insertOrUpdate")
    @ApiOperation("新增或者更新顾客信息")
    public Message insertOrUpdate( Customer customer)throws Exception{
        try{
            customerService.insertOrUpdate(customer);
            return MessageUtil.success("success");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error("更新失败");
        }
    }
    @GetMapping("deleteCustomerById")
    @ApiOperation("根据ID更新顾客信息")
    public Message deleteCustomerById(@ApiParam(value="主键",required=true)@RequestParam("id") Long id) throws Exception{
        try {
            customerService.deleteCustomerById(id);
            return MessageUtil.success("success");
        }catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error("删除失败");
        }
    }
    @GetMapping("query")
    @ApiOperation("模糊查询顾客信息")
    public Message query(Customer customer){
        List<Customer> list=customerService.query(customer);
        return MessageUtil.success("success",list);
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message BatchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception {
        try {
            customerService.batchDelete(ids);
            return MessageUtil.success("批量删除成功");
        }catch (Exception e)
        {
            e.printStackTrace();
            return MessageUtil.error("删除失败");
        }
}
    @PostMapping("findOrderAllMessageById")
    @ApiOperation("根据Order的ID查询某订单的详细信息")
    public Message findOrderAllMessageById(@NotNull @RequestParam("id") Long id){
        List<OrderExtend> list =customerService.findOrderAllMessageById(id);
        return MessageUtil.success("success",list);
    }
    @ApiOperation("查询客户或者服务者全部订单信息")
    @GetMapping("query2")
    public Message query2(Long customerId, Long waiterId){
        if(customerId==null&&waiterId==null){
            return MessageUtil.error("客户ID与顾客ID不能同时为空！");
        }
       else {
            try {
                List<OrderExtend> list = customerService.query2(customerId, waiterId);
                return MessageUtil.success("success", list);
            } catch (Exception e) {
                e.printStackTrace();
                return MessageUtil.error(e.getMessage());
            }
        }
    }
}
