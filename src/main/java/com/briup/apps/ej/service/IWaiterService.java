package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.bean.extend.OrderExtend;

import java.util.List;

public interface IWaiterService {
    List<Waiter> findAll();
    Waiter findWaiterById(Long id);
    void insertOrUpdate(Waiter product)throws Exception;
    void deleteWaiterById(Long id) throws Exception;
    List<Waiter> query(Waiter waiter);
    void batchDelete(long[] ids)throws Exception;
    List<OrderExtend> findWaiterOrderMessageById(Long id);
}
