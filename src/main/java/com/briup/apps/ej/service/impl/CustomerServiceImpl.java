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
    public List<Customer> query(Customer customer) {
        CustomerExample example=new CustomerExample();
        //通过客户姓名模糊查询
        if (customer.getRealname()!=null){
            example.createCriteria().andRealnameLike("%"+customer.getRealname()+"%");

        }
        //通过客户电话模糊查询
        if (customer.getTelephone()!=null){
            example.createCriteria().andTelephoneLike("%"+customer.getTelephone()+"%");

        }

        return customerMapper.selectByExample(example);
    }


    @Override
    public int saveOrUpdate(Customer customer){
        //id自动生成
        if(customer.getId()== null) {
            customer.setStatus("正常");
            return customerMapper.insert(customer);
        }else {
            return customerMapper.updateByPrimaryKey(customer);
        }

    }


    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id : ids){
            customerMapper.deleteByPrimaryKey(id);

        }

    }

    @Override
    public int deleteById(Long id) throws Exception{
        Customer customer=customerMapper.selectByPrimaryKey(id);
        if (customer == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            return customerMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int close(Long id){
     Customer customer = customerMapper.selectByPrimaryKey(id);
     customer.setStatus("封禁");
     return 1;
    }

    @Override
    public int open(Long id){
        Customer customer = customerMapper.selectByPrimaryKey(id);
        customer.setStatus("解封");
        return 1;
    }
}
