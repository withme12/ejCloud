package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;
    @ApiOperation("保存或更新用户地址信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Address address) throws Exception{
        addressService.saveOrUpdate(address);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation("通过ID删除用户地址信息")
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        try{
            addressService.deleteById(id);
            return MessageUtil.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("通过ID查找地址信息")
    @GetMapping("selectById")
    public Message selectById(Long id){
        if(id==null)
            return MessageUtil.error("用户地址不存在");
        else{
            Address address = addressService.selectById(id);
            return MessageUtil.success("查找成功",address);
        }
    }


}
