package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.ProductExample;
import com.briup.apps.ej.utils.Message;

import java.util.List;
//测试 查询部抛出异常，增删改要抛出异常
public interface IProductService {
    List<Product> findAll();

    // List<CustomerExample> query(CustomerExample customerExample);

    Product selectById(Long id);

    int saveOrUpdate(Product customer) throws Exception;

    int deleteById(Long id) throws  Exception;

}
