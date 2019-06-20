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
        ProductExample example=new ProductExample();
        return productMapper.selectByExample(example);
    }

//    @Override
//    public List<Product> findProductUnderCategory(Long id) {
//        productMapper.
//        ProductExample example=new ProductExample();
//       if(id=product){}
//        return productMapper.selectByExample(example);
//    }

    @Override
    public Product findProductById(Long id) {

        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertOrUpdate(Product product) throws Exception {
        if(product.getId()!=null){
            product.setStatus("正常");
            productMapper.updateByPrimaryKey(product);
        }else{
            product.setStatus("正常");
            productMapper.insert(product);
        }
    }

    @Override
    public void deleteProductById(Long id) throws Exception {
        productMapper.deleteByPrimaryKey(id);
    }


    @Override
    public List<Product> query(String name) {
        ProductExample example=new ProductExample();
        if(name!=null){
            example.createCriteria().andNameLike("%"+name+"%");
        }

        return productMapper.selectByExample(example);
    }

    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id:ids){
            productMapper.deleteByPrimaryKey(id);
        }
    }

}
