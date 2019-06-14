package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.OrderLineExample;
import com.briup.apps.ej.dao.OrderLineMapper;
import com.briup.apps.ej.service.IOrderLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class OrderLineServiceImpl  implements IOrderLineService {
    @Resource
    private OrderLineMapper orderLineMapper;
    @Override
    public List<OrderLine> findAll() {
        OrderLineExample example=new OrderLineExample();
        return orderLineMapper.selectByExample(example);
    }



    @Override
    public OrderLine findById(Long id) {
        return orderLineMapper.selectByPrimaryKey(id);
    }



    @Override
    public void deleteById(long id) throws Exception {
        OrderLine orderLine=orderLineMapper.selectByPrimaryKey(id);
        if (orderLine==null){
            throw new Exception("要删除的订单项不存在");

        }else {
            orderLineMapper.deleteByPrimaryKey(id);
        }

    }
}
