package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.ProductExample;
import com.briup.apps.ej.dao.ProductMapper;
import com.briup.apps.ej.service.IProductService;

import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;

@Service 
public class ProductServiceImpl implements IProductService{
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll(){
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);
    }

    //详细信息查看（通过id）
    @Override
    public Product selectById(Long id){
        return productMapper.selectByPrimaryKey(id);

    }

    //产品信息更改或者新增产品信息
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

    //单个删除(通过id)
    @Override
    public int deleteById(Long id) throws Exception{
        Product product=productMapper.selectByPrimaryKey(id);

              if (product == null) {
            throw new Exception("要删除的产品不存在");
        } else {
            return productMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDelete(Long[] ids) throws Exception {
        for (long id : ids)
            productMapper.deleteByPrimaryKey(id);
    }

}
