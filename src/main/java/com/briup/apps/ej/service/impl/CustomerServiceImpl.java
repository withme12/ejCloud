package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import com.briup.apps.ej.dao.CustomerMapper;
import com.briup.apps.ej.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll() {
        CustomerExample example = new CustomerExample();
        return customerMapper.selectByExample(example);
    }

    @Override
    public Customer selectById(Long id){
        return customerMapper.selectByPrimaryKey(id);

    }
    @Override
    public int saveOrUpdate(Customer customer){
        if(customer.getId()== null) {
            customer.setStatus("正常");
            return customerMapper.insert(customer);
        }else {
            return customerMapper.updateByPrimaryKey(customer);
        }

    }


    @Override
    public int deleteById(Long id) throws Exception{
        if (id == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            return customerMapper.deleteByPrimaryKey(id);
        }
    }
}
