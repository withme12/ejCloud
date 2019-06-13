package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import com.briup.apps.ej.utils.Message;

import java.util.List;
//测试 查询部抛出异常，增删改要抛出异常
public interface ICustomerService {
    List<Customer> findAll();

    // List<CustomerExample> query(CustomerExample customerExample);

    Customer selectById(Long id);

    int saveOrUpdate(Customer customer) throws Exception;

    int deleteById(Long id) throws  Exception;

    int close(Long id);

    int open(Long id);

}

