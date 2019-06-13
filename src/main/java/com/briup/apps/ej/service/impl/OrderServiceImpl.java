package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
//import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.dao.OrderMapper;
import com.briup.apps.ej.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderServiceImpl implements IOrderService{
    @Resource
    private OrderMapper orderMapper;
    /*
    @Resource
    private OrderExtend orderExtend;
    @Override
    public  List<OrderExtend> query
    */

    @Override
    public List<Order> findAll() {
        OrderExample example = new OrderExample();
        return orderMapper.selectByExample(example);
    }

    @Override
    public Order selectById(Long id){
        return orderMapper.selectByPrimaryKey(id);

    }
    @Override
    public int saveOrUpdate(Order order){
        //id自动生成
        if(order.getId()== null) {

            return orderMapper.insert(order);
        }else {
            return orderMapper.updateByPrimaryKey(order);
        }

    }


    @Override
    public int deleteById(Long id) throws Exception{
        if (id == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            return orderMapper.deleteByPrimaryKey(id);
        }
    }


}
