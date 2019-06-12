package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Product;

import java.util.List;

public interface IProductService {
    int deleteById(Long id);

    Product selectById(Long id);


}
