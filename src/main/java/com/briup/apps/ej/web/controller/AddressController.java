package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "地址管理接口")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;


    @ApiOperation("查找所有用户地址")
    @GetMapping("findAll")
    public Message findAll(){
        List<Address> list = addressService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("（ID自动生成，请勿输入ID）保存或更新用户地址信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Address address) throws Exception{
        addressService.saveOrUpdate(address);
        return MessageUtil.success("保存成功");
    }
    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Address address){
        List<Address> list=addressService.query(address);

        return MessageUtil.success("success",list);
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
        Address address = addressService.selectById(id);
        if(address==null)
            return MessageUtil.error("用户地址不存在");
        else{
            return MessageUtil.success("查找成功",address);
        }
    }


}
