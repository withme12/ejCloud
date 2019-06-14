package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Waiter;

import java.util.List;

public interface IWaiterService {
    List<Waiter> query(Waiter waiter);
    int saveOrUpdate(Waiter waiter) throws Exception;

    int deleteById(Long id) throws Exception;

    List<Waiter> selectAll();
}
