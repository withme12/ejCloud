package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.*;
import com.briup.apps.ej.bean.extend.AddressExtend;

import java.util.List;

public interface IAddressService {
    int deleteByPrimaryKey(Long id);
   // int insert(Address record);
    int deleteByPrimaryKeys(Long[] ids);
    Address selectByPrimaryKey(Long id);
   // int updateByPrimaryKeySelective(Address record);
    int insertOrUpdate(Address address);
    List<Address> findAll();
    List<Address>  query(Address address);
//    List<AddressExtend> findAllWithCustomer();
List<AddressExtend> findCustomerAddressById(Long id);
}
