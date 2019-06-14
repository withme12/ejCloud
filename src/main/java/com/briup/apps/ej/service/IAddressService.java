package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Address;

public interface IAddressService {
    Address selectById(Long id);

    int saveOrUpdate(Address address) throws Exception;

    int deleteById(Long id) throws  Exception;
}
