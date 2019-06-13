package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.extend.OrderExtend;

import java.util.List;

public interface IOrderService {
    //级联查询尚未实现
    //List<OrderExtend> query(Long customeId,Long waiterId)
    List<Order> findAll();


    Order selectById(Long id);

    int saveOrUpdate(Order order) throws Exception;

    int deleteById(Long id) throws  Exception;






}
