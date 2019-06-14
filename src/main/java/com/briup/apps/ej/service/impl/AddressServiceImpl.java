package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.AddressExample;
import com.briup.apps.ej.dao.AddressMapper;
import com.briup.apps.ej.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;
    @Override
    public Address selectById(Long id) {
        return addressMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<Address> query(Address address) {
        AddressExample example=new AddressExample();
        //通过地址模糊查询
        if (address.getAddress()!=null){
            example.createCriteria().andAddressLike("%"+address.getAddress()+"%");

        }
        //通过地区模糊查询
        if (address.getArea()!=null){
            example.createCriteria().andAreaLike("%"+address.getArea()+"%");

        }
        //通过城市模糊查询
        if (address.getCity()!=null){
            example.createCriteria().andCityLike("%"+address.getCity()+"%");

        }
        //通过省份模糊查询
        if (address.getProvince()!=null){
            example.createCriteria().andProvinceLike("%"+address.getProvince()+"%");

        }
        return addressMapper.selectByExample(example);
    }
    @Override
    public int saveOrUpdate(Address address) throws Exception {
        if(address.getId()== null) {

            return addressMapper.insert(address);
        }else {
            return addressMapper.updateByPrimaryKey(address);
        }

    }

    @Override
    public int deleteById(Long id) throws Exception {
        Address address=addressMapper.selectByPrimaryKey(id);

        if (address == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            return addressMapper.deleteByPrimaryKey(id);
        }
    }
}
