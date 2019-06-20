package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.VM.OrderVM;
import com.briup.apps.ej.bean.extend.OrderExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    Order findOrderById(Long id);
    void insertOrUpdate(Order order)throws Exception;
    void deleteOrderById(Long id) throws Exception;
    void batchDelete(long[] ids) throws Exception;
    List<OrderVM> queryBasic(Long customerId,Long waiterId);

}