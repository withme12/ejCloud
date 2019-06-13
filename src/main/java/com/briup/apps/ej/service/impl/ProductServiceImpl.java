package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.ProductExample;
import com.briup.apps.ej.dao.ProductMapper;
import com.briup.apps.ej.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);
    }

    @Override
    public Product selectById(Long id){
        return productMapper.selectByPrimaryKey(id);

    }
    @Override
    public int saveOrUpdate(Product product){
        //id自动生成
        if(product.getId()== null) {
            product.setStatus("正常");
            return productMapper.insert(product);
        }else {
            return productMapper.updateByPrimaryKey(product);
        }

    }


    @Override
    public int deleteById(Long id) throws Exception{
        if (id == null) {
            throw new Exception("要删除的产品不存在");
        } else {
            return productMapper.deleteByPrimaryKey(id);
        }
    }
}

