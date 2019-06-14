package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.service.IWaiterService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "员工管理接口")
@RestController
@RequestMapping("/Waiter")
public class WaiterController {
    @Autowired
    private IWaiterService iWaiterService;

    @ApiOperation("查找所有服务员")
    @GetMapping("findAll")
    public Message findAll(){
        List<Waiter> list = iWaiterService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Waiter waiter){
        List<Waiter> list=iWaiterService.query(waiter);

        return MessageUtil.success("success",list);
    }
    @ApiOperation("查找全部员工")
    @GetMapping("/selectAll")
    public Message selectAll(){
        List<Waiter> waiterList = iWaiterService.selectAll();
        return  MessageUtil.success("查找成功",waiterList);
    }

    @ApiOperation("根据ID删除员工信息")
    @GetMapping("/deleteById")
    public Message deleteById(Long id) throws Exception{
        if(iWaiterService.deleteById(id)==1)
            return MessageUtil.success("删除成功");
        else
            return MessageUtil.error("删除失败");
    }

    @ApiOperation("（ID自动生成，请勿输入ID）录入或更改员工信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Waiter waiter) throws Exception{
        if(iWaiterService.saveOrUpdate(waiter)==1)
            return MessageUtil.success("成功",waiter);
        else
            return MessageUtil.error("失败");
    }
    @ApiOperation("批量删除（数据用“,”隔开）")
    @PostMapping("batchDelete")
    public Message batchDelete(Long[] ids) throws Exception{
        iWaiterService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }

    @ApiOperation("通过ID查找员工信息")
    @GetMapping("selectById")
    public Message selectById(long id){
        Waiter waiter= iWaiterService.selectById(id);
        if(waiter==null)
            return MessageUtil.error("用户不存在");
        else{
            return MessageUtil.success("查找成功",waiter);
        }
    }

}
