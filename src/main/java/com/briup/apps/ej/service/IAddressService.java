package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Address;

import java.util.List;

public interface IAddressService {
    Address selectById(Long id);
    List<Address> query(Address address);
    int saveOrUpdate(Address address) throws Exception;

    int deleteById(Long id) throws  Exception;
}
