package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findProductById(Long id);
    void insertOrUpdate(Product product)throws Exception;
    void deleteProductById(Long id) throws Exception;
    List<Product> query(String name);
    void batchDelete(long[] ids)throws Exception;
//    List<Product> findProductUnderCategory();
}
