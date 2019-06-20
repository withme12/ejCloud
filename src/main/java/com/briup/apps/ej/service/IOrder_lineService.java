package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderLine;

import com.briup.apps.ej.bean.extend.OrderLineExtend;


import java.util.List;

public interface IOrder_lineService {
//    int deleteByPrimaryKey(Long id);
//    int updateByPrimaryKey(Order_line record);
//    int insert(Order_line record);
//    Order_line selectByPrimaryKey(Long id);
    List<OrderLine> findAll();
    OrderLine findOrder_lineById(Long id);
    void insertOrUpdate( OrderLine order_line)throws Exception;
    void deleteOrder_lineById(Long id) throws Exception;
    void batchDelete(long[] ids) throws Exception;
    List<OrderLineExtend> findOrderDetails(Long id);
}
