package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.dao.AddressMapper;
import com.briup.apps.ej.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service

public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;
    @Override
    public Address selectById(Long id) {
        return addressMapper.selectByPrimaryKey(id);
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
