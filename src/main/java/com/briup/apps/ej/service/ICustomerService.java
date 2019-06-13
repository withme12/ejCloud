package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import com.briup.apps.ej.utils.Message;

import java.util.List;
//测试
public interface ICustomerService {
    List<Customer> findAll();

    // List<CustomerExample> query(CustomerExample customerExample);

    Customer selectById(Long id);

    int saveOrUpdate(Customer customer) throws Exception;

    int deleteById(Long id) throws  Exception;

    int close(Long id);

    int open(Long id);

}

