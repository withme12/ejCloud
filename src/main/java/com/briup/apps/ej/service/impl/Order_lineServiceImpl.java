package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.OrderLineExample;
import com.briup.apps.ej.bean.extend.OrderLineExtend;
import com.briup.apps.ej.dao.OrderLineMapper;
import com.briup.apps.ej.dao.extend.Order_lineExtendMapper;
import com.briup.apps.ej.service.IOrder_lineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Order_lineServiceImpl implements IOrder_lineService {
    @Resource
    private OrderLineMapper order_lineMapper;
    @Resource
    private Order_lineExtendMapper orderLineExtendMapper;
    @Override
    public List<OrderLine> findAll() {
        OrderLineExample order_lineExample=new OrderLineExample();
        return order_lineMapper.selectByExample(order_lineExample);
    }

    @Override
    public OrderLine findOrder_lineById(Long id) {
        return order_lineMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertOrUpdate(OrderLine order_line) throws Exception {
        if(order_line.getId()!=null){

            order_lineMapper.updateByPrimaryKey(order_line);
        }
    }

    @Override
    public void deleteOrder_lineById(Long id) throws Exception {
        OrderLine order_line = order_lineMapper.selectByPrimaryKey(id);
        if(order_line == null){
            throw new Exception("要删除的用户不存在");
        } else {
            order_lineMapper.deleteByPrimaryKey(id);
        }

    }

    @Override
    public void batchDelete(long[] ids) throws Exception {
        for (long id : ids){
            order_lineMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<OrderLineExtend> findOrderDetails(Long id) {
        return orderLineExtendMapper.findOrderDetails(id);
    }

}
