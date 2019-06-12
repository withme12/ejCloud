package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.service.ICustomerService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("findAll")
    public Message findAll(){
        List<Customer> list = customerService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("保存或更新用户信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Customer customer) throws Exception{
            customerService.saveOrUpdate(customer);
            return MessageUtil.success("保存成功");
        }

    @ApiOperation("通过ID删除用户信息")
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        try{
            customerService.deleteById(id);
            return MessageUtil.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("通过ID查找用户信息")
    @GetMapping("selectById")
    public Message selectById(Long id){
        if(id==null)
            return MessageUtil.error("用户不存在");
        else{
            Customer customer = customerService.selectById(id);
            return MessageUtil.success("查找成功",customer);
        }
    }
}
